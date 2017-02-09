import {AppController} from "../Controllers/AppController";
import {WindowDrawer} from "./WindowDrawer";
import {MapController} from "../Controllers/MapController";
import {MarkersService} from "../Services/MarkersService";
import {CategoriesService} from "../Services/CategoriesService";
import {GeoCodeService} from "../Services/GeoCodeService";
import {TagsService} from "../Services/TagsService";
declare var GOOGLE_MAP_API_KEY:number;
declare var google:any;


//import {CommentsView} from "../Views/CommentsView";
declare var $:JQueryStatic|any;

export class ActionBinder {
    static firstBind:boolean = true;

    static bindActions(container: Object) {
        if(this.firstBind) {
            AppController.instances[0].addClickCallback((mapController:MapController,e)=>{
                if(mapController.mode==1) { // add marker
                    mapController.setMode(0);
                    $('#map').addClass('inactive');
                    AppController.instances[0].map.setZoom(18);
                    AppController.instances[0].map.setCenter(new google.maps.LatLng(e.latLng.lat(), e.latLng.lng()));
                    MarkersService.reserveMarkerId([(markerId)=>{
                        mapController.putMarker({
                            'latitude':e.latLng.lat(),
                            'longitude':e.latLng.lng(),
                            'title':'',
                            'id':markerId
                        });

                        GeoCodeService.getGeoCodeData(e.latLng.lat(),e.latLng.lng(),GOOGLE_MAP_API_KEY,[(GeoCodeData) => {
                            CategoriesService.getCategories([(CategoriesData) => {
                                WindowDrawer.drawCreateMarkerWindow({
                                    'id':markerId,
                                    'latitude':e.latLng.lat(),
                                    'longitude':e.latLng.lng()
                                }, GeoCodeData, CategoriesData);
                            }]);
                        }]);
                    }]);
                }
            });
            $('#show-my-bookmarked-markers').click((event)=>{
                $('#map').removeClass('inactive');
                MarkersService.getBookmarkedMarkers([(MarkersData)=>{
                    WindowDrawer.drawMarkersListWindow('Избранные метки',MarkersData,'favourites');
                    ActionBinder.pushState('#favourites');
                }]);
            });

            $('#show-my-markers').click((event)=>{
                $('#map').removeClass('inactive');
                MarkersService.getMyMarkers([(MarkersData)=>{
                    WindowDrawer.drawMarkersListWindow('Мои метки',MarkersData,'my-markers');
                    ActionBinder.pushState('#my-markers');
                }]);
            });

            $('#show-search').click((event)=>{
                $('#map').removeClass('inactive');
                CategoriesService.getCategories([(CategoriesData) => {
                    TagsService.getPopularTags([(TagsData) => {
                        WindowDrawer.drawSearchWindow(CategoriesData,TagsData);
                    }]);
                }]);
            });

            $('#show-my-comments').click((event)=>{
                $('#map').removeClass('inactive');
                MarkersService.getCommentedMarkers([(MarkersData)=>{
                    WindowDrawer.drawMarkersListWindow('Мои Комментарии',MarkersData,'my-comments');
                    ActionBinder.pushState('#my-comments');
                }]);
            });

            $('[data-click-id]').click(function (event) {
                var $this = $(this);
                $('#'+$this.data('click-id')).click();
            });
        }
        this.firstBind = false;
    }

    static pushState(state:string) {
        $('#header-menu [data-base-href]').each(function () {
            var $this = $(this);
            console.log(($this.data('base-href')+state.substr(1)));
            $this.attr('href',($this.data('base-href')+state.substr(1)));
        });
        if (history.pushState) {
            history.pushState(null, null, state);
        } else {
            location.hash = state;
        }
    }
}