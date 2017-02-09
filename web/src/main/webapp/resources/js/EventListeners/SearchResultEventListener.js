define(["require", "exports", "../Services/MarkersService", "../Helpers/WindowDrawer", "../Controllers/AppController"], function (require, exports, MarkersService_1, WindowDrawer_1, AppController_1) {
    "use strict";
    var SearchResultEventListener = (function () {
        function SearchResultEventListener() {
        }
        SearchResultEventListener.eventCallback = function (window) {
            window.windowContainer.find('.marker .marker-list .marker-item').click(function (event) {
                var MarkerId = $(event.currentTarget).data('marker-id');
                MarkersService_1.MarkersService.getMarker(MarkerId, [function (MarkerData) {
                        WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData, window);
                    }, function (MarkerData) {
                        AppController_1.AppController.instances[0].map.setZoom(18);
                        AppController_1.AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                        AppController_1.AppController.instances[0].reloadMarkers();
                    }]);
            });
        };
        return SearchResultEventListener;
    }());
    exports.SearchResultEventListener = SearchResultEventListener;
});
