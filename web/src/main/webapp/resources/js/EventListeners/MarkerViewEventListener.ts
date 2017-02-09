import {WindowController} from "../Controllers/WindowController";
import {WindowDrawer} from "../Helpers/WindowDrawer";
import {CategoriesService} from "../Services/CategoriesService";
import {MarkersService} from "../Services/MarkersService";
import {GeoCodeService} from "../Services/GeoCodeService";
import {CommentsService} from "../Services/CommentsService";
import {AppController} from "../Controllers/AppController";
declare var google,jQuery,$:any;
declare var GOOGLE_MAP_API_KEY:number;
declare var IS_AUTHENTICATED:boolean;

export class MarkerViewEventListener {
    static eventCallback(window : WindowController) {
        ///////////////////
        //  MARKER VIEW  //
        ///////////////////

        // Open Comments Button
        window.windowContainer.find('.marker .open-comments-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id');
            CommentsService.getCommentsForMarker(markerId,[(MarkerData)=>{
                WindowDrawer.drawCommentWindow(markerId,MarkerData,window);
            }]);
        });

        // Edit Marker Button
        window.windowContainer.find('.marker .edit-marker-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id');

            MarkersService.getMarker(markerId,[(MarkerData)=>{
                GeoCodeService.getGeoCodeData(MarkerData.coordinates.latitude,MarkerData.coordinates.longitude,GOOGLE_MAP_API_KEY,[(GeoCodeData) => {
                    CategoriesService.getCategories([(CategoriesData) => {
                        WindowDrawer.drawEditMarkerWindow(MarkerData, GeoCodeData, CategoriesData, window);
                    }]);
                }]);
            }]);
        });

        window.windowContainer.find('.marker .tags .btn').click(function () {
            var $this = $(this);
            var startTime = (new Date()).getTime();

            MarkersService.searchMarkersByParameters({
                "rating": [],
                "categories": [],
                "tags": [$this.text().trim()],
                "address": {
                    "phrases":[]
                }
            }, [(MarkersFoundData) => {
                WindowDrawer.drawMarkersListWindow('Результаты поиска', MarkersFoundData,'search-list', window);
            }, (MarkersFoundData) => {
                $.toast({
                    hideAfter: 5000,
                    heading: 'Поиск завершен',
                    icon: 'info',
                    text: 'Поиск и отображение результатов завершено, за '+(((new Date()).getTime()-startTime)/1000).toFixed(2)+'с',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }]);
        });

        window.windowContainer.find('.marker .categories .btn').click(function () {
            var $this = $(this);
            var startTime = (new Date()).getTime();

            MarkersService.searchMarkersByParameters({
                "rating": [],
                "categories": [$this.text().trim()],
                "tags": [],
                "address": {
                    "phrases":[]
                }
            }, [(MarkersFoundData) => {
                WindowDrawer.drawMarkersListWindow('Результаты поиска', MarkersFoundData,'search-list', window);
            }, (MarkersFoundData) => {
                $.toast({
                    hideAfter: 5000,
                    heading: 'Поиск завершен',
                    icon: 'info',
                    text: 'Поиск и отображение результатов завершено, за '+(((new Date()).getTime()-startTime)/1000).toFixed(2)+'с',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }]);
        });

        if(IS_AUTHENTICATED) {
            window.windowContainer.find('.add-remove-bookmarks-button').each(function (el) {
                var $this = $(this);
                MarkersService.getBookmarkedMarkers([(MarkersData)=>{
                    MarkersData.map((Marker)=>{
                        if(parseInt($this.data('marker-id'))==Marker.id)
                            $(this).addClass('added');
                        return Marker;
                    });
                }]);
            });
        }

        // Add/Remove Marker To/From Bookmarks
        window.windowContainer.find('.marker .add-remove-bookmarks-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id'),
                added : boolean = $button.hasClass('added');

            if(IS_AUTHENTICATED) {
                if(!added){
                    MarkersService.addMarkerToBookmarks(markerId,[(BD)=>{
                        $button.addClass('added');
                    }]);
                } else {
                    MarkersService.deleteMarkerFromBookmarks(markerId,[(BD)=>{
                        $button.removeClass('added');
                    }]);
                }
            } else {
                $.toast({
                    heading: 'Войдите на ресурс',
                    icon: 'info',
                    hideAfter: false,
                    text: 'Перед тем как добавлять метки в избранное,<br>войдите на ресурс при момощи социальных сетей.<br><a class="header-button" href="/signGoogle?fallback_url=" data-base-href="/signGoogle?fallback_url='+location.hash.substr(1)+'"><i class="fa fa-google-plus" aria-hidden="true"></i></a> <a class="header-button" href="/signFacebook?fallback_url='+location.hash.substr(1)+'" data-base-href="/signFacebook?fallback_url="><i class="fa fa-facebook" aria-hidden="true"></i></a>',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            }
        });


        // Remove Marker Button
        window.windowContainer.find('.marker .remove-marker-button').click((event)=>{
            var $button = $(event.currentTarget),
                window : WindowController = $button.parents('.window').data('model'),
                markerId : number = $button.data('marker-id');

            MarkersService.deleteMarker(markerId,[(RemoveResultData)=>{
                $.toast({
                    hideAfter: 5000,
                    heading: 'Метка удалена',
                    icon: 'info',
                    text: 'Метка успешно удалена.',
                    position: {
                        top: 75,
                        right: 20,
                    },
                    stack: 5
                });
            },(RemoveResultData)=>{
                window.closeWindow();
            },(RemoveResultData)=>{
                AppController.instances[0].reloadMarkers();
            }]);
        });


        // Attachments
        window.windowContainer.find('.marker .attachments a').featherlightGallery({
            gallery: {
                fadeIn: 300,
                fadeOut: 300
            },
            openSpeed: 300,
            closeSpeed: 300
        });
    }
}