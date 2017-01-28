import {WindowController} from "./WindowController";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {AppController} from "./AppController";
declare var google:any;
declare var MarkerClusterer:any;
export class MapController {
    map: any;
    mainWindow: WindowController;
    mapClusterer: any;
    mode: any;
    /***
     * Creates map.
     */
    constructor(DOMEntityID, mapOptions) {
        var mapElement = document.getElementById(DOMEntityID);
        this.map = new google.maps.Map(mapElement, mapOptions);
        this.mapClusterer = new MarkerClusterer(
            this.map,[],{
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
    setMode(mode) {
        this.mode = mode;
    }

    /***
     * Reloads Markers when map moved to another location.
     */
    reloadMarkers(options:any = {}) {
        var bounds = this.map.getBounds(),
            ne_pos = bounds.getNorthEast(), // правый верхний
            sw_pos = bounds.getSouthWest(); // левый нижний
        console.log("NE:"+ne_pos.lat()+";"+ne_pos.lng());
        console.log("SW:"+sw_pos.lat()+";"+sw_pos.lng());
    }

    /***
     * Puts marker on map.
     */
    putMarker(options) {
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(options.latitude, options.longtitude),
            title: options.title
        });
        marker.addListener('click', function(e) {
            WindowDrawer.drawMarkerWindow(options.marker_id);
        });
        this.mapClusterer.addMarker(marker);
        this.mapClusterer.redraw();
        return marker;
    }
    /***
     * Puts markers on map.
     */
    putMarkers(options) {
        options.map((itm)=>{



            // TODO: REMOVE ON PRODUCTION
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(itm.latitude, itm.longtitude),
                title: itm.title
            });
            marker.addListener('click', function(e) {
                WindowDrawer.drawMarkerWindow(itm.marker_id);
            });
            this.mapClusterer.addMarker(marker);
            return marker;
        });
        this.mapClusterer.redraw();
        return options;
    }

    /***
     * Deletes marker from map.
     */
    removeMarker(marker) {
        marker.setMap(null);
        marker = null;
    }
}