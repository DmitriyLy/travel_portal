define(["require", "exports", "./Controllers/AppController", "./Controllers/DayNightModeEventController", "./Controllers/FloatingButtonsEventController", "./Controllers/MMenuEventController", "./Helpers/ActionBinder", "./Helpers/WindowDrawer", "./Controllers/WindowController", "./EventListeners/WindowEventListener", "./EventListeners/MarkerViewEventListener", "./EventListeners/MarkerEditEventListener", "./EventListeners/CommentsEventListener", "./Services/MarkersService", "./Services/CommentsService", "./EventListeners/SearchResultEventListener", "./EventListeners/SearchMarkerEventListener"], function (require, exports, AppController_1, DayNightModeEventController_1, FloatingButtonsEventController_1, MMenuEventController_1, ActionBinder_1, WindowDrawer_1, WindowController_1, WindowEventListener_1, MarkerViewEventListener_1, MarkerEditEventListener_1, CommentsEventListener_1, MarkersService_1, CommentsService_1, SearchResultEventListener_1, SearchMarkerEventListener_1) {
    "use strict";
    // Init Map
    AppController_1.AppController.instantiateMap('map', {
        zoom: 11,
        latlng: new google.maps.LatLng(46.4701764, 30.6293825),
        styles: [{ "featureType": "landscape", "elementType": "geometry", "stylers": [{ "saturation": "-100" }] }, { "featureType": "poi", "elementType": "labels", "stylers": [{ "visibility": "off" }] }, { "featureType": "poi", "elementType": "labels.text.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road", "elementType": "labels.text", "stylers": [{ "color": "#545454" }] }, { "featureType": "road", "elementType": "labels.text.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway", "elementType": "geometry.fill", "stylers": [{ "saturation": "-87" }, { "lightness": "-40" }, { "color": "#ffffff" }] }, { "featureType": "road.highway", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway.controlled_access", "elementType": "geometry.fill", "stylers": [{ "color": "#f0f0f0" }, { "saturation": "-22" }, { "lightness": "-16" }] }, { "featureType": "road.highway.controlled_access", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.highway.controlled_access", "elementType": "labels.icon", "stylers": [{ "visibility": "on" }] }, { "featureType": "road.arterial", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "road.local", "elementType": "geometry.stroke", "stylers": [{ "visibility": "off" }] }, { "featureType": "water", "elementType": "geometry.fill", "stylers": [{ "saturation": "-52" }, { "hue": "#00e4ff" }, { "lightness": "-16" }] }]
    });
    // Add Event Listeners to Windows
    WindowController_1.WindowController.bindAfterCreate(WindowEventListener_1.WindowEventListener.eventCallback);
    WindowController_1.WindowController.bindAfterCreate(MarkerViewEventListener_1.MarkerViewEventListener.eventCallback);
    WindowController_1.WindowController.bindAfterCreate(MarkerEditEventListener_1.MarkerEditEventListener.eventCallback);
    WindowController_1.WindowController.bindAfterCreate(CommentsEventListener_1.CommentsEventListener.eventCallback);
    WindowController_1.WindowController.bindAfterCreate(SearchMarkerEventListener_1.SearchMarkerEventListener.eventCallback);
    WindowController_1.WindowController.bindAfterCreate(SearchResultEventListener_1.SearchResultEventListener.eventCallback);
    // Modules init
    // 1. Material Design Module Init
    // $.material.init();
    // 2. MMenu module init and map resizing fix
    MMenuEventController_1.MMenuEventController.init();
    // 3. Floating action buttons events
    FloatingButtonsEventController_1.FloatingButtonsEventController.init();
    // 4. Day-Night mode buttons events
    DayNightModeEventController_1.DayNightModeEventController.init();
    ActionBinder_1.ActionBinder.bindActions($('html body'));
    // END
    // $(document).ready(()=>{
    //     setTimeout(()=>{
    //         AppController.instances[0].reloadMarkers();
    //     },200);
    // });
    // check for #marker-999999
    if (location.hash.match(/^#marker-([0-9]+)/g)) {
        var m = (/^#marker-([0-9]+)/g).exec(location.hash);
        if (m.length) {
            MarkersService_1.MarkersService.getMarker(parseInt(m[1]), [function (MarkerData) {
                    WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData);
                }, function (MarkerData) {
                    AppController_1.AppController.instances[0].map.setZoom(18);
                    AppController_1.AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                    AppController_1.AppController.instances[0].reloadMarkers();
                }]);
        }
    }
    // check for #marker-comments-999999
    if (location.hash.match(/^#marker-comments-([0-9]+)/g)) {
        var m = (/^#marker-comments-([0-9]+)/g).exec(location.hash);
        if (m.length) {
            MarkersService_1.MarkersService.getMarker(parseInt(m[1]), [function (MarkerData) {
                    WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData, null, [function (MarkerWindow) {
                            CommentsService_1.CommentsService.getCommentsForMarker(parseInt(m[1]), [function (CommentsData) {
                                    WindowDrawer_1.WindowDrawer.drawCommentWindow(parseInt(m[1]), CommentsData, MarkerWindow);
                                }]);
                        }]);
                }, function (MarkerData) {
                    AppController_1.AppController.instances[0].map.setZoom(18);
                    AppController_1.AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                    AppController_1.AppController.instances[0].reloadMarkers();
                }]);
        }
    }
});
