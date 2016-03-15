var userName = "swhite"; // Currently hardcoded

// #################################### Map ####################################

var view = new ol.View({
    zoom: 8
});

var map = new ol.Map({
    layers: [new ol.layer.Tile({
        source: new ol.source.MapQuest({layer: 'osm'})
    })], target: 'map', controls: ol.control.defaults({
        attributionOptions: ({
            collapsible: false
        })
    }), view: view
});

// ################################# Geolocation #################################

var geolocation = new ol.Geolocation({
    projection: view.getProjection()
});
geolocation.on('error', function (error) {
    alert(error.message);
});
var positionFeature = new ol.Feature();
positionFeature.setStyle(new ol.style.Style({
    image: new ol.style.Icon({src: "horse.png", scale: 0.25})
}));
var centerDefined = false;
geolocation.on('change:position', function () {
    var coordinates = geolocation.getPosition();
    $.ajax({
        url: "/user/" + userName + "swhite/location/" + coordinates[0] + "," + coordinates[1], type: "PUT"
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

map.on('singleclick', function (evt) {
    var coordinate = evt.coordinate;
    var hdms = ol.coordinate.toStringHDMS(ol.proj.transform(coordinate, 'EPSG:3857', 'EPSG:4326'));
    var message = '<p>You clicked here:</p><code>' + hdms + '</code>';

    var container = document.createElement("div");
    container.className = "ol-popup";
    //var content = document.createElement("div");
    //container.appendChild(content);
    //content.innerHTML = message;
    var popup = new ol.Overlay(({
        element: container, autoPan: true, autoPanAnimation: {
            duration: 250
        }
    }));
    map.addOverlay(popup)
    popup.setPosition(coordinate);
    $(container).editable(function(value, settings) {
        $.ajax({
            method: "POST",
            url: "/message",
            data: JSON.stringify({content: value, author: userName, location: {type: "Point", coordinates:[coordinate[0],coordinate[1]]}}),
            contentType:"application/json; charset=utf-8",
            dataType:"json"});
        return value;
    }, { type : 'textarea', submit: 'OK'});

});
