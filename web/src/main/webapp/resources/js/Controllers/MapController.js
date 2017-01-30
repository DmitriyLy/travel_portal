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
            this.addDragEndCallback(function (mapController, e) {
                mapController.reloadMarkers();
            });
            return this;
        }
        /***
         * Set mouse mode for map.
         * 0 - Drag
         * 1 - PutMarker
         * 2 - EditMarker
         * 3 - RemoveMarker - deprecated do not use
         */
        MapController.prototype.setMode = function (mode) {
            this.mode = mode;
        };
        MapController.prototype.addClickCallback = function (func) {
            var mapController = this;
            this.map.addListener('click', function (e) {
                func(mapController, e);
            });
        };
        MapController.prototype.addDragEndCallback = function (func) {
            var mapController = this;
            this.map.addListener('dragend', function (e) {
                func(mapController, e);
            });
        };
        /***
         * Reloads Markers when map moved to another location.
         */
        MapController.prototype.reloadMarkers = function (options) {
            var _this = this;
            if (options === void 0) { options = {}; }
            var bounds = this.map.getBounds(), ne_pos = bounds.getNorthEast(), // правый верхний
            sw_pos = bounds.getSouthWest(); // левый нижний
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: 'http://nctravelportal.ddns.net/labels/search/by/area/rectangle',
                data: JSON.stringify({
                    'topRight': {
                        'latitude': ne_pos.lat(),
                        'longtitude': ne_pos.lng()
                    },
                    'bottomLeft': {
                        'latitude': sw_pos.lat(),
                        'longtitude': sw_pos.lng()
                    }
                }),
                dataType: 'json',
                success: function (MarkerData) {
                    console.log(MarkerData);
                    _this.resetMarkers(MarkerData);
                },
                error: function (error) { console.log(error); alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
            });
            console.log("TopRight  :" + ne_pos.lat() + ";" + ne_pos.lng());
            console.log("LeftBottom:" + sw_pos.lat() + ";" + sw_pos.lng());
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
        MapController.prototype.resetMarkers = function (options) {
            var _this = this;
            this.mapClusterer.getMarkers().map(function (itm) { _this.mapClusterer.removeMarker(itm); });
            this.putMarkers(options);
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
