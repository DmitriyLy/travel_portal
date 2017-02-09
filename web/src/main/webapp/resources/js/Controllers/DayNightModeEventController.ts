import {AppController} from "./AppController";
import {MapController} from "./MapController";

declare var $:JQueryStatic|any;

export class DayNightModeEventController {
    static styles : any = {
        light: [{
            "featureType": "landscape",
            "elementType": "geometry",
            "stylers": [{"saturation": "-100"}]
        }, {"featureType": "poi", "elementType": "labels", "stylers": [{"visibility": "off"}]}, {
            "featureType": "poi",
            "elementType": "labels.text.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "road",
            "elementType": "labels.text",
            "stylers": [{"color": "#545454"}]
        }, {
            "featureType": "road",
            "elementType": "labels.text.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "road.highway",
            "elementType": "geometry.fill",
            "stylers": [{"saturation": "-87"}, {"lightness": "-40"}, {"color": "#ffffff"}]
        }, {
            "featureType": "road.highway",
            "elementType": "geometry.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "road.highway.controlled_access",
            "elementType": "geometry.fill",
            "stylers": [{"color": "#f0f0f0"}, {"saturation": "-22"}, {"lightness": "-16"}]
        }, {
            "featureType": "road.highway.controlled_access",
            "elementType": "geometry.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "road.highway.controlled_access",
            "elementType": "labels.icon",
            "stylers": [{"visibility": "on"}]
        }, {
            "featureType": "road.arterial",
            "elementType": "geometry.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "road.local",
            "elementType": "geometry.stroke",
            "stylers": [{"visibility": "off"}]
        }, {
            "featureType": "water",
            "elementType": "geometry.fill",
            "stylers": [{"saturation": "-52"}, {"hue": "#00e4ff"}, {"lightness": "-16"}]
        }],
        dark: [{"stylers":[{"hue":"#ff1a00"},{"invert_lightness":true},{"saturation":-100},{"lightness":33},{"gamma":0.5}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#2D333C"}]}]
    };
    static init() {
        $('#dn-mode-button').click((el) => {
            var $body = $('body'), $this = $(el.currentTarget);
            $body.toggleClass('dark');

            if($body.hasClass('dark')) {
                AppController.theme = 'dark';
                $this.children('i').removeClass('fa-moon-o').addClass('fa-sun-o');
            } else {
                AppController.theme = 'light';
                $this.children('i').removeClass('fa-sun-o').addClass('fa-moon-o');
            }

            AppController.instances.forEach((mapController : MapController) => {
                mapController.map.setOptions({styles: AppController.theme=='light'?this.styles.light:this.styles.dark});
            });
        });
    }
}

