import {WindowController} from "./WindowController";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {AppController} from "./AppController";
import {MarkersService} from "../Services/MarkersService";
declare var google:any;
declare var jQuery,$:any;
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
        this.addZoomChangedCallback((mapController:MapController,e)=>{
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

    addBoundsChangedCallback(func:Function){
        var mapController = this;
        this.map.addListener('bounds_changed', function(e) {
            func(mapController,e);
        });
    }

    addZoomChangedCallback(func:Function){
        var mapController = this;
        this.map.addListener('zoom_changed', function(e) {
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
            success: (MarkerData) => {
                this.resetMarkers(MarkerData.map((itm) => {
                    return {
                        'latitude': itm.coordinates.latitude,
                        'longitude': itm.coordinates.longitude,
                        'title': 'Метка #' + itm.id,
                        'marker_id': itm.id
                    };
                }));
            },
            error: (error) => {
                console.log(error);
                $.toast({
                    hideAfter: 5000,
                    heading: 'Произошла ошибка',
                    icon: 'error',
                    text: 'Произошла ошибка №'+error.status+'.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });
    }

    /***
     * Puts marker on map.
     */
    putMarker(options) {
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(options.latitude, options.longitude),
            title: options.title
        });
        var __this = this;

        marker.addListener('click', function(e) {
            MarkersService.getMarker(options.marker_id,[(MarkerData)=>{
                WindowDrawer.drawMarkerWindow(MarkerData);
            },(MarkerData)=>{
                __this.map.setZoom(18);
                __this.map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                __this.reloadMarkers();
            }]);
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
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(itm.latitude, itm.longitude),
                title: itm.title
            });
            var __this = this;
            marker.addListener('click', function(e) {
                MarkersService.getMarker(itm.marker_id,[(MarkerData)=>{
                    WindowDrawer.drawMarkerWindow(MarkerData);
                },(MarkerData)=>{
                    __this.map.setZoom(18);
                    __this.map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                    __this.reloadMarkers();
                }]);
            });
            this.mapClusterer.addMarker(marker);
            return marker;
        });
        this.mapClusterer.redraw();
        return options;
    }

    resetMarkers(options) {
        while(true) {
            var markers = this.mapClusterer.getMarkers();
            if(markers.length<=0) break;
            markers.map((itm)=>{this.mapClusterer.removeMarker(itm);})
        }
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