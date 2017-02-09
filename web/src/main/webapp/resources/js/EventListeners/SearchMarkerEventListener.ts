import {WindowController} from "../Controllers/WindowController";
import {CommentsViewHolder} from "../Views/CommentsViewHolder";
import {MarkersService} from "../Services/MarkersService";
import {WindowDrawer} from "../Helpers/WindowDrawer";
declare var google,jQuery,$:any;
declare var USER_ID:number;

export class SearchMarkerEventListener {
    static eventCallback(window : WindowController) {
        window.windowContainer.find('.search #regular-marker-search').click((event)=>{
            var startTime = (new Date()).getTime();
            MarkersService.searchMarkersByParameters({
                "address": {
                    "phrases":window.windowContainer.find('.search #regular_search .address input').val().split(',').map((itm) => {
                        return itm.trim().toLowerCase();
                    }).filter((entry) => {
                        return entry.trim() != '';
                    })
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

        window.windowContainer.find('.search #tags_search .tags .btn').click(function () {
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

        window.windowContainer.find('.search #advanced_search #categories-container').chosen();

        window.windowContainer.find('.search #advanced-marker-search').click((event)=>{
            var startTime = (new Date()).getTime();
            var ratingContainers = window.windowContainer.find('.search #advanced_search .rating input[type=checkbox][name="rating"]:checked');
            var rating = [];

            for(var i = 0; i<ratingContainers.length; i++)
                rating.push($(ratingContainers[i]).val());

            rating = rating.length ? rating.map((itm)=>{return parseInt(itm);}) : [];

            MarkersService.searchMarkersByParameters({
                "rating": rating,
                "categories": window.windowContainer.find('.search #advanced_search #categories-container').val(),
                "tags": window.windowContainer.find('.search #advanced_search .tags input').val().split(',').map((itm) => {
                    return itm.trim();
                }).filter((entry) => {
                    return entry.trim() != '';
                }),
                "address": {
                    "phrases":window.windowContainer.find('.search #advanced_search .address input').val().split(',').map((itm) => {
                        return itm.trim().toLowerCase();
                    }).filter((entry) => {
                        return entry.trim() != '';
                    })
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
    }
}