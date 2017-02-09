define(["require", "exports", "../Services/MarkersService", "../Helpers/WindowDrawer"], function (require, exports, MarkersService_1, WindowDrawer_1) {
    "use strict";
    var SearchMarkerEventListener = (function () {
        function SearchMarkerEventListener() {
        }
        SearchMarkerEventListener.eventCallback = function (window) {
            window.windowContainer.find('.search #regular-marker-search').click(function (event) {
                var startTime = (new Date()).getTime();
                MarkersService_1.MarkersService.searchMarkersByParameters({
                    "address": {
                        "phrases": window.windowContainer.find('.search #regular_search .address input').val().split(',').map(function (itm) {
                            return itm.trim().toLowerCase();
                        }).filter(function (entry) {
                            return entry.trim() != '';
                        })
                    }
                }, [function (MarkersFoundData) {
                        WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Результаты поиска', MarkersFoundData, 'search-list', window);
                    }, function (MarkersFoundData) {
                        $.toast({
                            hideAfter: 5000,
                            heading: 'Поиск завершен',
                            icon: 'info',
                            text: 'Поиск и отображение результатов завершено, за ' + (((new Date()).getTime() - startTime) / 1000).toFixed(2) + 'с',
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
                MarkersService_1.MarkersService.searchMarkersByParameters({
                    "rating": [],
                    "categories": [],
                    "tags": [$this.text().trim()],
                    "address": {
                        "phrases": []
                    }
                }, [function (MarkersFoundData) {
                        WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Результаты поиска', MarkersFoundData, 'search-list', window);
                    }, function (MarkersFoundData) {
                        $.toast({
                            hideAfter: 5000,
                            heading: 'Поиск завершен',
                            icon: 'info',
                            text: 'Поиск и отображение результатов завершено, за ' + (((new Date()).getTime() - startTime) / 1000).toFixed(2) + 'с',
                            position: {
                                top: 75,
                                right: 20,
                            },
                            stack: 5
                        });
                    }]);
            });
            window.windowContainer.find('.search #advanced_search #categories-container').chosen();
            window.windowContainer.find('.search #advanced-marker-search').click(function (event) {
                var startTime = (new Date()).getTime();
                var ratingContainers = window.windowContainer.find('.search #advanced_search .rating input[type=checkbox][name="rating"]:checked');
                var rating = [];
                for (var i = 0; i < ratingContainers.length; i++)
                    rating.push($(ratingContainers[i]).val());
                rating = rating.length ? rating.map(function (itm) { return parseInt(itm); }) : [];
                MarkersService_1.MarkersService.searchMarkersByParameters({
                    "rating": rating,
                    "categories": window.windowContainer.find('.search #advanced_search #categories-container').val(),
                    "tags": window.windowContainer.find('.search #advanced_search .tags input').val().split(',').map(function (itm) {
                        return itm.trim();
                    }).filter(function (entry) {
                        return entry.trim() != '';
                    }),
                    "address": {
                        "phrases": window.windowContainer.find('.search #advanced_search .address input').val().split(',').map(function (itm) {
                            return itm.trim().toLowerCase();
                        }).filter(function (entry) {
                            return entry.trim() != '';
                        })
                    }
                }, [function (MarkersFoundData) {
                        WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Результаты поиска', MarkersFoundData, 'search-list', window);
                    }, function (MarkersFoundData) {
                        $.toast({
                            hideAfter: 5000,
                            heading: 'Поиск завершен',
                            icon: 'info',
                            text: 'Поиск и отображение результатов завершено, за ' + (((new Date()).getTime() - startTime) / 1000).toFixed(2) + 'с',
                            position: {
                                top: 75,
                                right: 20,
                            },
                            stack: 5
                        });
                    }]);
            });
        };
        return SearchMarkerEventListener;
    }());
    exports.SearchMarkerEventListener = SearchMarkerEventListener;
});
