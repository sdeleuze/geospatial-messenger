function el(id) {
    return document.getElementById(id);
}

var view = new ol.View({
    zoom: 8
});

var geolocation = new ol.Geolocation({
    projection: view.getProjection()
});

var map = new ol.Map({
    layers: [new ol.layer.Tile({
        source: new ol.source.OSM()
    })], target: 'map', controls: ol.control.defaults({
        attributionOptions: /** @type {olx.control.AttributionOptions} */ ({
            collapsible: false
        })
    }), view: view
});

geolocation.on('change', function () {
    el('accuracy').innerText = geolocation.getAccuracy() + ' [m]';
    el('altitude').innerText = geolocation.getAltitude() + ' [m]';
    el('altitudeAccuracy').innerText = geolocation.getAltitudeAccuracy() + ' [m]';
    el('heading').innerText = geolocation.getHeading() + ' [rad]';
    el('speed').innerText = geolocation.getSpeed() + ' [m/s]';
});

// handle geolocation error.
geolocation.on('error', function (error) {
    var info = document.getElementById('info');
    info.innerHTML = error.message;
    info.style.display = '';
});

var positionFeature = new ol.Feature();

geolocation.on('change:position', function () {
    var coordinates = geolocation.getPosition();
    positionFeature.setGeometry(coordinates ? new ol.geom.Point(coordinates) : null);
    view.setCenter(coordinates);
});

new ol.layer.Vector({
    map: map, source: new ol.source.Vector({
        features: [positionFeature]
    })
});

geolocation.setTracking(true);

var select = new ol.interaction.Select();
map.addInteraction(select);
select.on('select', function (e) {
    el('status').innerHTML = '&nbsp;' + e.target.getFeatures().getLength() + ' selected features';

});


