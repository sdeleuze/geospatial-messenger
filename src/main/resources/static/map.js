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
        source: new ol.source.OSM()
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
    image: new ol.style.Icon({src: "u.png", scale: 0.5})
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

var element = document.getElementById('popup');

var popup = new ol.Overlay({
        element: element,
        positioning: 'bottom-center'
});
map.addOverlay(popup);

// display popup on click
map.on('click', function(evt) {
    var coordinate = evt.coordinate;
    var feature = map.forEachFeatureAtPixel(evt.pixel,
        function(feature) {
          return feature;
    });

    $(element).popover('destroy');
    if (feature) {
      popup.setPosition(coordinate);
      $(element).popover({
        'placement': 'top',
        'html': true,
        'content': feature.get('content'),
        'animation': false
      });
      $(element).popover('show');
    } else {
        popup.setPosition(coordinate);
      $(element).popover({
        'placement': 'top',
        'html': true,
        'title': "New message",
        'animation': false
         
      }).data('bs.popover').tip().width(300).height(300).append("<div id='message' style='height:70%'/>");
      $(element).popover('show');
        $("#message").editable(function(value, settings) {
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
    }
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
                        content: value.content,
                        author: value.author
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
    style: new ol.style.Style({image: new ol.style.Icon({src: "m.png", scale: 0.5})}),
});

map.addLayer(vector);


// ############################## SSE for message push ##############################

var source = new EventSource("/message/subscribe");

source.addEventListener('message', function(e) {
  var message = $.parseJSON(e.data);
  var feature = new ol.Feature({
                        geometry: new ol.geom.Point(message.location.coordinates),
                        content: message.content,
                        author: message.author
                    });
  vectorSource.addFeature(feature);
}, false);
