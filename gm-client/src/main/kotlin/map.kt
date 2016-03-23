
import declarations.alert
import declarations.append
import declarations.j
import jquery.jq
import openlayers.ol
import openlayers.olx
import org.w3c.dom.EventSource
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.MessageEvent
import kotlin.Pair
import kotlin.browser.document

private fun fillUsersSelect() {
    j.getJSON("/user") { data: Array<dynamic> ->
        for (d in data) {

            val user = (document.createElement("option") as HTMLOptionElement).apply {
                value = d.userName
                text = d.firstName + " " + d.lastName
            }

            jq("#select-user").append(user)
        }
    }
}

private fun createMap(): Pair<ol.View, ol.Map> {
    val view = ol.View(object : olx.ViewOptions {
        override var zoom: Number? = 4
    })

    val map = ol.Map(object : olx.MapOptions {
        override var layers: Array<Any>? =
                arrayOf(
                        ol.layer.Tile(object/* : olx.layer.TileOptions*/ {
                            /*override */var source: ol.source.Source? = ol.source.MapQuest(object {
                                val layer = "osm"
                            })
                        } as olx.layer.TileOptions)
                )
        override var target: Any? = "map"
        override var controls: Any? = ol.control.defaults(object : olx.control.DefaultsOptions {
            override var attributionOptions: Any? = object {
                val collapsible = false
            }
        })

        override var view: ol.View? = view
    })
    return Pair(view, map)
}

private fun setupGeolocation(map: ol.Map, view: ol.View) {
    val geolocation = ol.Geolocation(object : olx.GeolocationOptions {
        override var projection = view.getProjection()
    })

    geolocation.on("error", { error ->
        // todo test: looks like error doesn't have message
        alert("Geolocation error: " + error.asDynamic().message);
    })

    val positionFeature = ol.Feature()
    positionFeature.setStyle(ol.style.Style(object : olx.style.StyleOptions {
        override var image: ol.style.Image? = ol.style.Icon(object : olx.style.IconOptions {
            override var src: String? = "u.png";
            override var scale: Number? = 0.5
        })
    }))

    var centerDefined = false
    geolocation.on("change:position", {
        // should be nullable?
        val coordinates = geolocation.getPosition()
        j.ajax(object {
            val url = "/user/" + jq("#select-user").`val`() + "/location/" + coordinates[0] + "," + coordinates[1]
            val type = "PUT"
        })

        if (!centerDefined) {
            view.setCenter(coordinates)
            centerDefined = true
        }

        positionFeature.setGeometry(if (coordinates == null) ol.geom.Point(coordinates) else null)
    })

    ol.layer.Vector(object : olx.layer.VectorOptions {
        /// ???
        override var map = map
        override var source: ol.source.Source? = ol.source.Vector(object : olx.source.VectorOptions {
            override var features = arrayOf(positionFeature)
        })
    })

    geolocation.setTracking(true)
}

private fun setupPopup(map: ol.Map) {
    val element = document.getElementById("popup")

    fun ol.Overlay.show(coordinate: ol.Coordinate, content: Any, additionalSetup: dynamic.() -> Unit = {}){
        j(element).popover("destroy")

        setPosition(coordinate)
        j(element).popover(object {
            val placement = "top"
            val html = true
            val content = content
            val animation = false
        }).additionalSetup()

        j(element).popover("show")
    }

    val popup = ol.Overlay(object : olx.OverlayOptions {
        override var element = element
        override var positioning = "bottom-center" as ol.OverlayPositioning?
    })

    map.addOverlay(popup)

    // display popup on click
    map.on("click", { e ->
        val coordinate = e.coordinate
        val feature = map.forEachFeatureAtPixel(e.pixel, { feature, layer -> feature })

        if (feature != null) {
            popup.show(coordinate, feature.get("content"))
        } else {
            popup.show(coordinate, "New message") {
                data("bs.popover").tip()
                        .width(300).height(300)
                        .append("<div id='message' style='height:70%'/>")
            }

            j("#message").editable({ value, settings ->
                j.ajax(object {
                    val method = "POST"
                    val url = "/message"
                    val data = JSON.stringify(object {
                        val content = value
                        val author = jq("#select-user").`val`()
                        val location = object {
                            val type = "Point";
                            val coordinates = arrayOf(coordinate[0], coordinate[1])
                        }
                    })
                    val contentType = "application/json; charset=utf-8"
                    val dataType = "json"
                })

                popup.setPosition()

                value
            }, object {
                val type = "textarea"
                val submit = "OK"
            })
        }
    })
}

private fun setupMessageLayer(map: ol.Map): ol.source.Vector {
    var vectorSourceRef: ol.source.Vector? = null
    val vectorSource = ol.source.Vector(object/* : olx.source.VectorOptions*/ {
        /*override */var loader: ol.FeatureLoader? = { extent: ol.Extent, number: Number, projection: ol.proj.Projection ->

            var url = "/message/bbox/" + extent[0] + "," + extent[1] + "," + extent[2] + "," + extent[3]
            j.ajax(object {
                val url = url
                val dataType = "json"
                val success = { response: dynamic ->
                    if (response.error) {
                        alert(response.error.message + '\n' + response.error.details.join('\n'))
                    } else {
                        j.each(response) { index: Int, value: dynamic ->
                            var feature = ol.Feature(object {
                                val geometry = ol.geom.Point(value.location.coordinates)
                                val content = value.content
                                val author = value.autho
                            })

                            vectorSourceRef!!.addFeature(feature)
                        }
                    }
                }
            })
        } as ol.FeatureLoader
    } as olx.source.VectorOptions)

    vectorSourceRef = vectorSource

    val vector = ol.layer.Vector(object/*: olx.layer.VectorOptions*/ {
        /*override */var source: ol.source.Source? = vectorSource
        /*override */var style = ol.style.Style(object : olx.style.StyleOptions {
            override var image: ol.style.Image? = ol.style.Icon(object : olx.style.IconOptions {
                override var src: String? = "m.png";
                override var scale: Number? = 0.5
            })
        })
    } as olx.layer.VectorOptions)

    map.addLayer(vector)
    return vectorSource
}

private fun setupMessagePush(vectorSource: ol.source.Vector) {
    val source = EventSource("/message/subscribe")

    //todo: report issue
    source.addEventListener("message", {
        val e = it as MessageEvent

        val message = j.parseJSON(e.data)
        val feature = ol.Feature(object {
            val geometry = ol.geom.Point(message.location.coordinates)
            val content = message.content
            val author = message.author
        })

        vectorSource.addFeature(feature)
    })
}


fun main(args: Array<String>) {
    fillUsersSelect()
    val (view, map) = createMap()
    setupGeolocation(map, view)
    setupPopup(map)
    val vectorSource = setupMessageLayer(map)
    setupMessagePush(vectorSource)
}
