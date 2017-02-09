import {WindowController} from "../Controllers/WindowController";
import {CommentsViewHolder} from "../Views/CommentsViewHolder";
import {MarkersService} from "../Services/MarkersService";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {AppController} from "../Controllers/AppController";
declare var google,jQuery,$:any;
declare var USER_ID:number;

export class SearchResultEventListener {
    static eventCallback(window : WindowController) {
        window.windowContainer.find('.marker .marker-list .marker-item').click((event)=>{
            var MarkerId = $(event.currentTarget).data('marker-id');
            MarkersService.getMarker(MarkerId,[(MarkerData)=>{
                WindowDrawer.drawMarkerWindow(MarkerData, window);
            },(MarkerData)=>{
                AppController.instances[0].map.setZoom(18);
                AppController.instances[0].map.setCenter(new google.maps.LatLng(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude));
                AppController.instances[0].reloadMarkers();
            }]);
        });
    }
}