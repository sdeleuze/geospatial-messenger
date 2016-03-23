
import jquery.jq
import openlayers.ol
import openlayers.olx
import org.w3c.dom.EventSource
import kotlin.browser.document

fun main(args: Array<String>) {
    j.getJSON("/user") { data: Array<dynamic> ->
        for (d in data) {
            val user = j("<option>", object {
                val value = d.userName
                val text = d.firstName + " " + d.lastName
            })

            jq("#select-user").append(user);
        }
    }

// #################################### Map ####################################

    val viewOptions: olx.ViewOptions = object : olx.ViewOptions {
        override var zoom: Number? = 4
    }
    ///???
    val view = ol.View(viewOptions);

    val map = ol.Map(object : olx.MapOptions {
        override var layers: Array<Any>? =
                arrayOf(
                ol.layer.Tile(object /*: olx.layer.TileOptions*/ {
                    /// ???
                    /*override */var source: ol.source.Source? = ol.source.MapQuest(object { val layer = "osm" })
                } as olx.layer.TileOptions)
        )
        override var target: Any? = "map"
        override var controls: Any? = ol.control.defaults(object : olx.control.DefaultsOptions {
            override var attributionOptions: Any? = object { val collapsible = false }
        })

        override var view: olx.ViewOptions? = view.asDynamic()
    });

// ################################# Geolocation #################################

    val geolocation = ol.Geolocation(object: olx.GeolocationOptions {
        override var projection: dynamic = view.getProjection()
    })

    geolocation.on("error", { error ->
        alert("Geolocation error: " + error.asDynamic().message);
    })
    val positionFeature = ol.Feature()
    positionFeature.setStyle(ol.style.Style( object : olx.style.StyleOptions {
        override var image: ol.style.Image? = ol.style.Icon(object: olx.style.IconOptions { override var src: String? = "u.png"; override var scale: Number? = 0.5})
    }));

    var centerDefined = false;
    geolocation.on("change:position", {
        // should be nullable?
        val coordinates = geolocation.getPosition();
        j.ajax(object {
            val url = "/user/" + jq("#select-user").`val`() + "/location/" + coordinates[0] + "," + coordinates[1]
            val type = "PUT"
        })

        if (!centerDefined) {
            view.setCenter(coordinates);
            centerDefined = true;
        }
        positionFeature.setGeometry(if (coordinates == null) ol.geom.Point(coordinates) else null);
    })

    ol.layer.Vector(object : olx.layer.VectorOptions{
        /// ???
        override var map = map
        override var source: ol.source.Source? = ol.source.Vector(object : olx.source.VectorOptions {
            override var features = arrayOf(positionFeature)
        })
    })

    geolocation.setTracking(true);

// ################################# Popup #################################

    val element = document.getElementById("popup")

    var popup = ol.Overlay(object : olx.OverlayOptions {
        override var element = element
        override var positioning = "bottom-center".asDynamic()
    })

    map.addOverlay(popup);

// display popup on click
    map.on("click", { evt: dynamic ->
        var coordinate = evt.coordinate;
        var feature = map.forEachFeatureAtPixel(evt.pixel, { feature, layer -> feature });

        j(element).popover("destroy")
        if (feature != null) {
            popup.setPosition(coordinate)
            j(element).popover(object {
                val placement = "top"
                val html = true
                val content = feature.asDynamic().get("content")
                val animation = false
            });
            j(element).popover("show")
        } else {
            popup.setPosition(coordinate)
            j(element).popover(object {
                val placement = "top"
                val html = true
                val title = "New message"
                val animation = false

            }).data("bs.popover").tip().width(300).height(300).append("<div id='message' style='height:70%'/>")

            j(element).popover("show")
            j("#message").editable({value, settings ->
                j.ajax(object {
                    val method = "POST"
                    val url = "/message"
                    val data = JSON.stringify(object {
                        val content = value
                        val author = jq("#select-user").`val`()
                        val location = object { val type = "Point"; val coordinates = arrayOf(coordinate[0],coordinate[1])}
                    })
                    val contentType = "application/json; charset=utf-8"
                    val dataType = "json"
                })

                popup.setPosition()

                value
            }, object {
                val type = "textarea"
                val submit = "OK"
            });
        }
    });


// ################################# Messages layer #################################

    var vectorSource: ol.source.Vector? = null
    vectorSource = ol.source.Vector(object/* : olx.source.VectorOptions*/ {
        /*override */var loader: ol.FeatureLoader? = /*todo fun(extent: ol.Extent, number: Number, projection: ol.proj.Projection)*/ {
            extent: ol.Extent, number: Number, projection: ol.proj.Projection ->

            var url = "/message/bbox/" + extent[0] + "," + extent[1] + "," + extent[2] + "," + extent[3];
            j.ajax(object {
                val url = url
                val dataType = "json"
                val success = /*todo fun(response: dynamic)*/ { response: dynamic ->
                    if (response.error) {
                        alert(response.error.message + '\n' +
                                response.error.details.join('\n'));
                    } else {
                        j.each(response, /*todo fun(index: Int, value: dynamic)*/ { index: Int, value: dynamic ->
                            var feature = ol.Feature(object {
                                val geometry = ol.geom.Point(value.location.coordinates)
                                val content = value.content
                                val author = value.autho
                            })

                            vectorSource!!.addFeature(feature);
                        });
                    }
                }
            })
        } as ol.FeatureLoader
    } as olx.source.VectorOptions)

    val vector = ol.layer.Vector(object/*: olx.layer.VectorOptions*/ {
        /*override */var source: ol.source.Source? = vectorSource
        /*override */var style =ol.style.Style(object : olx.style.StyleOptions {
            override var image: ol.style.Image? = ol.style.Icon(object : olx.style.IconOptions { override var src: String? = "m.png"; override var scale: Number? = 0.5})
        })
    } as olx.layer.VectorOptions);

    map.addLayer(vector);


// ############################## SSE for message push ##############################
    val source = EventSource("/message/subscribe")

    source.addEventListener("message", { e ->
        val message = j.parseJSON(e.asDynamic().data)
        val feature = ol.Feature(object {
            val geometry = ol.geom.Point(message.location.coordinates)
            val content = message.content
            val author = message.author
        });

        // bad message w/o !!
        vectorSource!!.addFeature(feature);
    })
}

@native("$") val j: dynamic = noImpl
@native fun alert(a: Any) {}
