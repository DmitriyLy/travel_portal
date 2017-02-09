define(["require", "exports", "../Helpers/WindowDrawer", "../Services/MarkersService"], function (require, exports, WindowDrawer_1, MarkersService_1) {
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
            this.addZoomChangedCallback(function (mapController, e) {
                mapController.reloadMarkers();
            });
            var _this = this;
            google.maps.event.addDomListener(window, 'load', function () {
                _this.reloadMarkers();
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
        MapController.prototype.addBoundsChangedCallback = function (func) {
            var mapController = this;
            this.map.addListener('bounds_changed', function (e) {
                func(mapController, e);
            });
        };
        MapController.prototype.addZoomChangedCallback = function (func) {
            var mapController = this;
            this.map.addListener('zoom_changed', function (e) {
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
                url: '/labels/search/by/area/rectangle',
                data: JSON.stringify({
                    'topRight': {
                        'latitude': ne_pos.lat(),
                        'longitude': ne_pos.lng()
                    },
                    'bottomLeft': {
                        'latitude': sw_pos.lat(),
                        'longitude': sw_pos.lng()
                    }
                }),
                dataType: 'json',
                success: function (MarkerData) {
                    _this.resetMarkers(MarkerData.map(function (itm) {
                        return {
                            'latitude': itm.coordinates.latitude,
                            'longitude': itm.coordinates.longitude,
                            'title': 'Метка #' + itm.id,
                            'marker_id': itm.id
                        };
                    }));
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        /***
         * Puts marker on map.
         */
        MapController.prototype.putMarker = function (options) {
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(options.latitude, options.longitude),
                title: options.title
            });
            var __this = this;
            marker.addListener('click', function (e) {
                MarkersService_1.MarkersService.getMarker(options.marker_id, [function (MarkerData) {
                        WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData);
                    }, function (MarkerData) {
                        __this.map.setZoom(18);
                        __this.map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                        __this.reloadMarkers();
                    }]);
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
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(itm.latitude, itm.longitude),
                    title: itm.title
                });
                var __this = _this;
                marker.addListener('click', function (e) {
                    MarkersService_1.MarkersService.getMarker(itm.marker_id, [function (MarkerData) {
                            WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData);
                        }, function (MarkerData) {
                            __this.map.setZoom(18);
                            __this.map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                            __this.reloadMarkers();
                        }]);
                });
                _this.mapClusterer.addMarker(marker);
                return marker;
            });
            this.mapClusterer.redraw();
            return options;
        };
        MapController.prototype.resetMarkers = function (options) {
            var _this = this;
            while (true) {
                var markers = this.mapClusterer.getMarkers();
                if (markers.length <= 0)
                    break;
                markers.map(function (itm) { _this.mapClusterer.removeMarker(itm); });
            }
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
