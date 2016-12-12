define(["require", "exports"], function (require, exports) {
    "use strict";
    var MapController = (function () {
        /***
         * Creates map.
         */
        function MapController(DOMEntityID, mapOptions) {
            var mapElement = document.getElementById(DOMEntityID);
            this.map = new google.maps.Map(mapElement, mapOptions);
            this.mode = 0; // 0 - drag, 1 - putMarker, 2 - viewMarker, 3 - removeMarker
            return this;
        }
        /***
         * Set mouse mode for map.
         * 0 - Drag
         * 1 - PutMarker
         * 2 - ViewMarker
         * 3 - RemoveMarker
         */
        MapController.prototype.setMode = function (mode) {
            this.mode = mode;
        };
        /***
         * Reloads Markers when map moved to another location.
         */
        MapController.prototype.reloadMarkers = function (options) {
            if (options === void 0) { options = {}; }
            var bounds = this.map.getBounds(), ne_pos = bounds.getNorthEast(), // правый верхний
            sw_pos = bounds.getSouthWest(); // левый нижний
            console.log("NE:" + ne_pos.lat() + ";" + ne_pos.lng());
            console.log("SW:" + sw_pos.lat() + ";" + sw_pos.lng());
        };
        /***
         * Puts marker on map.
         */
        MapController.prototype.putMarker = function (options) {
            return new google.maps.Marker({
                position: new google.maps.LatLng(options.latitude, options.longtitude),
                map: this.map,
                title: options.title
            });
        };
        /***
         * Deletes marker from map.
         */
        MapController.prototype.removeMarker = function (marker) {
            marker.setMap(null);
            marker = null;
        };
        return MapController;
    }());
    exports.MapController = MapController;
});
