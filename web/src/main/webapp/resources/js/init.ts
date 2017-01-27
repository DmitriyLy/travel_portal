import { AppController } from "./Controllers/AppController";
import { DayNightModeEventController } from "./Controllers/DayNightModeEventController";
import { FloatingButtonsEventController } from "./Controllers/FloatingButtonsEventController";
import { MMenuEventController } from "./Controllers/MMenuEventController";

declare var google,$:JQueryStatic|any;

// Init Map
AppController.instantiateMap('map', {
    zoom: 11,
    latlng: new google.maps.LatLng(40.6700, -73.9400),
    styles: [{"featureType":"landscape","elementType":"geometry","stylers":[{"saturation":"-100"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.text","stylers":[{"color":"#545454"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"saturation":"-87"},{"lightness":"-40"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#f0f0f0"},{"saturation":"-22"},{"lightness":"-16"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"saturation":"-52"},{"hue":"#00e4ff"},{"lightness":"-16"}]}]
});

// Modules init
// 1. Material Design Module Init
// $.material.init();
// 2. MMenu module init and map resizing fix
MMenuEventController.init();
// 3. Floating action buttons events
FloatingButtonsEventController.init();
// 4. Day-Night mode buttons events
DayNightModeEventController.init();
// END