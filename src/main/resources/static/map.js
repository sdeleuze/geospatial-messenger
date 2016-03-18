$.getJSON("/user", function(data) {
    $.each( data, function() {
        $('#select-user').append($('<option>', {
        value: this.userName,
        text : this.firstName + " " + this.lastName}));
    });
});

// #################################### Map ####################################

var view = new ol.View({
    zoom: 8
});

var map = new ol.Map({
    layers: [new ol.layer.Tile({
        source: new ol.source.MapQuest({layer: "osm"})
    })], target: "map", controls: ol.control.defaults({
        attributionOptions: ({
            collapsible: false
        })
    }), view: view
});

// ################################# Geolocation #################################

var geolocation = new ol.Geolocation({
    projection: view.getProjection()
});
geolocation.on("error", function (error) {
    alert("Geolocation error: " + error.message);
});
var positionFeature = new ol.Feature();
positionFeature.setStyle(new ol.style.Style({
    image: new ol.style.Icon({src: "horse.png", scale: 0.25})
}));
var centerDefined = false;
geolocation.on("change:position", function () {
    var coordinates = geolocation.getPosition();
    $.ajax({
        url: "/user/" + $('#select-user').val() + "/location/" + coordinates[0] + "," + coordinates[1], type: "PUT"
    });
    if (!centerDefined) {
        view.setCenter(coordinates);
        centerDefined = true;
    }
    positionFeature.setGeometry(coordinates ? new ol.geom.Point(coordinates) : null);
});
new ol.layer.Vector({
    map: map, source: new ol.source.Vector({
        features: [positionFeature]
    })
});
geolocation.setTracking(true);

// ################################# Popup #################################

var container = document.getElementById('popup');

var popup = new ol.Overlay(({
    element: container,
    autoPan: true,
    autoPanAnimation: {
        duration: 250
    }
}));
map.addOverlay(popup)

map.on('singleclick', function (evt) {
    var coordinate = evt.coordinate;
    popup.setPosition(coordinate);
    $(container).editable(function(value, settings) {
        $.ajax({
            method: "POST",
            url: "/message",
            data: JSON.stringify({content: value, author: $('#select-user').val(), location: {type: "Point", coordinates:[coordinate[0],coordinate[1]]}}),
            contentType: "application/json; charset=utf-8",
            dataType: "json"});
        popup.setPosition(undefined);
        return value;
    }, {
        type : "textarea",
        submit: "OK"
    });

});

// ################################# Messages layer #################################

var vectorSource = new ol.source.Vector({
        loader: function(extent, resolution, projection) {
          var url = '/message/bbox/' + extent[0] + "," + extent[1] + "," + extent[2] + "," + extent[3];
          $.ajax({url: url, dataType: 'json', success: function(response) {
            if (response.error) {
              alert(response.error.message + '\n' +
                  response.error.details.join('\n'));
            } else {
                $.each(response, function( index, value ) {
                    var feature = new ol.Feature({
                        geometry: new ol.geom.Point(value.location.coordinates),
                        data: value
                    });
                    vectorSource.addFeature(feature);
            });
            }
          }});
        },
        strategy: ol.loadingstrategy.tile(ol.tilegrid.createXYZ({
          tileSize: 512
        }))
      });

var vector = new ol.layer.Vector({
    source: vectorSource,
    style: new ol.style.Style({image: new ol.style.Icon({src: "pig.png", scale: 0.15})}),
});

map.addLayer(vector);
