define(["require", "exports", "./MapController"], function (require, exports, MapController_1) {
    "use strict";
    var AppController = (function () {
        function AppController() {
        }
        AppController.instantiateMap = function (containerId, options) {
            if (options.zoom == null)
                options.zoom = 11;
            if (options.latlng == null)
                options.latlng = new google.maps.LatLng(40.6700, -73.9400);
            if (options.styles == null)
                options.styles = [{ "featureType": "landscape", "elementType": "geometry", "stylers": [{ "saturation": "-100" }] }, { "featureType": "poi", "elementType": "labels", "stylers": [{ "visibility": "off" }] }, { "featureType": "poi", "elementType": "labels.text.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road", "elementType": "labels.text", "stylers": [{ "color": "#545454" }] }, { "featureType": "road", "elementType": "labels.text.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway", "elementType": "geometry.fill", "stylers": [{ "saturation": "-87" }, { "lightness": "-40" }, { "color": "#ffffff" }] }, { "featureType": "road.highway", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway.controlled_access", "elementType": "geometry.fill", "stylers": [{ "color": "#f0f0f0" }, { "saturation": "-22" }, { "lightness": "-16" }] }, { "featureType": "road.highway.controlled_access", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway.controlled_access", "elementType": "labels.icon", "stylers": [{ "visibility": "on" }] }, { "featureType": "road.arterial", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.local", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "water", "elementType": "geometry.fill", "stylers": [{ "saturation": "-52" }, { "hue": "#00e4ff" }, { "lightness": "-16" }] }];
            var mapController = new MapController_1.MapController(containerId, {
                zoom: options.zoom,
                center: options.latlng,
                disableDefaultUI: true,
                styles: options.styles
            });
            this.instances.push(mapController);
            return mapController;
        };
        AppController.theme = "light";
        AppController.instances = [];
        return AppController;
    }());
    exports.AppController = AppController;
});
