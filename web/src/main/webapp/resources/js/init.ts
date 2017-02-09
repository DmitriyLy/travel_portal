import { AppController } from "./Controllers/AppController";
import { DayNightModeEventController } from "./Controllers/DayNightModeEventController";
import { FloatingButtonsEventController } from "./Controllers/FloatingButtonsEventController";
import { MMenuEventController } from "./Controllers/MMenuEventController";
import {ActionBinder} from "./Helpers/ActionBinder";
import {WindowDrawer} from "./Helpers/WindowDrawer";
import {WindowController} from "./Controllers/WindowController";
import {WindowEventListener} from "./EventListeners/WindowEventListener";
import {MarkerViewEventListener} from "./EventListeners/MarkerViewEventListener";
import {MarkerEditEventListener} from "./EventListeners/MarkerEditEventListener";
import {CommentsEventListener} from "./EventListeners/CommentsEventListener";
import {MarkersService} from "./Services/MarkersService";
import {CommentsService} from "./Services/CommentsService";
import {SearchResultEventListener} from "./EventListeners/SearchResultEventListener";
import {SearchMarkerEventListener} from "./EventListeners/SearchMarkerEventListener";

declare var google,$:JQueryStatic|any;

// Init Map
AppController.instantiateMap('map', {
    zoom: 11,
    latlng: new google.maps.LatLng(46.4701764,30.6293825),
    styles: [{"featureType":"landscape","elementType":"geometry","stylers":[{"saturation":"-100"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.text","stylers":[{"color":"#545454"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"saturation":"-87"},{"lightness":"-40"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#f0f0f0"},{"saturation":"-22"},{"lightness":"-16"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"saturation":"-52"},{"hue":"#00e4ff"},{"lightness":"-16"}]}]
});

// Add Event Listeners to Windows
WindowController.bindAfterCreate(WindowEventListener.eventCallback);
WindowController.bindAfterCreate(MarkerViewEventListener.eventCallback);
WindowController.bindAfterCreate(MarkerEditEventListener.eventCallback);
WindowController.bindAfterCreate(CommentsEventListener.eventCallback);
WindowController.bindAfterCreate(SearchMarkerEventListener.eventCallback);
WindowController.bindAfterCreate(SearchResultEventListener.eventCallback);

// Modules init
// 1. Material Design Module Init
// $.material.init();
// 2. MMenu module init and map resizing fix
MMenuEventController.init();
// 3. Floating action buttons events
FloatingButtonsEventController.init();
// 4. Day-Night mode buttons events
DayNightModeEventController.init();
ActionBinder.bindActions($('html body'));
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
        MarkersService.getMarker(parseInt(m[1]),[(MarkerData)=>{
            WindowDrawer.drawMarkerWindow(MarkerData);
        },(MarkerData)=>{
            AppController.instances[0].map.setZoom(18);
            AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
            AppController.instances[0].reloadMarkers();
        }]);
    }
}

// check for #marker-comments-999999
if (location.hash.match(/^#marker-comments-([0-9]+)/g)) {
    var m = (/^#marker-comments-([0-9]+)/g).exec(location.hash);
    if (m.length) {
        MarkersService.getMarker(parseInt(m[1]),[(MarkerData)=>{
            WindowDrawer.drawMarkerWindow(MarkerData, null, [(MarkerWindow)=> {
                CommentsService.getCommentsForMarker(parseInt(m[1]),[(CommentsData)=>{
                    WindowDrawer.drawCommentWindow(parseInt(m[1]), CommentsData, MarkerWindow);
                }]);
            }]);
        },(MarkerData)=>{
            AppController.instances[0].map.setZoom(18);
            AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
            AppController.instances[0].reloadMarkers();
        }]);
    }
}
