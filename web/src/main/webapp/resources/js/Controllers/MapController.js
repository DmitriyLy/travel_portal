define(["require", "exports", "../Helpers/WindowDrawer"], function (require, exports, WindowDrawer_1) {
    "use strict";
    var MapController = (function () {
        /***
         * Creates map.
         */
        function MapController(DOMEntityID, mapOptions) {
            var mapElement = document.getElementById(DOMEntityID);
            this.map = new google.maps.Map(mapElement, mapOptions);
            this.mapClusterer = new MarkerClusterer(this.map, [], {
                imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'
            });
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
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(options.latitude, options.longtitude),
                title: options.title
            });
            marker.addListener('click', function (e) {
                WindowDrawer_1.WindowDrawer.drawMarkerWindow(options.marker_id);
            });
            this.mapClusterer.addMarker(marker);
            this.mapClusterer.redraw();
            return marker;
        };
        /***
         * Puts markers on map.
         */
        MapController.prototype.putMarkers = function (options) {
            var _this = this;
            options.map(function (itm) {
                // TODO: REMOVE ON PRODUCTION
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(itm.latitude, itm.longtitude),
                    title: itm.title
                });
                marker.addListener('click', function (e) {
                    WindowDrawer_1.WindowDrawer.drawMarkerWindow(itm.marker_id);
                });
                _this.mapClusterer.addMarker(marker);
                return marker;
            });
            this.mapClusterer.redraw();
            return options;
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
