import {WindowController} from "./WindowController";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {AppController} from "./AppController";
declare var google:any;
declare var MarkerClusterer:any;
export class MapController {
    map: any;
    mainWindow: WindowController;
    mapClusterer: any;
    mode: number;
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

        this.addDragEndCallback((mapController:MapController,e)=>{
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
    setMode(mode) {
        this.mode = mode;
    }

    addClickCallback(func:Function){
        var mapController = this;
        this.map.addListener('click', function(e) {
            func(mapController,e);
        });
    }

    addDragEndCallback(func:Function){
        var mapController = this;
        this.map.addListener('dragend', function(e) {
            func(mapController,e);
        });
    }



    /***
     * Reloads Markers when map moved to another location.
     */
    reloadMarkers(options:any = {}) {
        var bounds = this.map.getBounds(),
            ne_pos = bounds.getNorthEast(), // правый верхний
            sw_pos = bounds.getSouthWest(); // левый нижний

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'http://nctravelportal.ddns.net/labels/search/by/area/rectangle',
            data: JSON.stringify({
                'topRight':{
                    'latitude':    ne_pos.lat(),
                    'longtitude':  ne_pos.lng()
                },
                'bottomLeft':{
                    'latitude':    sw_pos.lat(),
                    'longtitude':  sw_pos.lng()
                }
            }),
            dataType: 'json',
            success: (MarkerData) => {
                console.log(MarkerData);
                this.resetMarkers(MarkerData);
            },
            error: (error) => { console.log(error);alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
        });

        console.log("TopRight  :"+ne_pos.lat()+";"+ne_pos.lng());
        console.log("LeftBottom:"+sw_pos.lat()+";"+sw_pos.lng());
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

    resetMarkers(options) {
        this.mapClusterer.getMarkers().map((itm)=>{this.mapClusterer.removeMarker(itm);});
        this.putMarkers(options);
    }

    /***
     * Deletes marker from map.
     */
    removeMarker(marker) {
        marker.setMap(null);
        marker = null;
    }
}