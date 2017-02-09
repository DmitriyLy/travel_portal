define(["require", "exports", "../Helpers/WindowDrawer", "../Services/CategoriesService", "../Services/MarkersService", "../Services/GeoCodeService", "../Services/CommentsService", "../Controllers/AppController"], function (require, exports, WindowDrawer_1, CategoriesService_1, MarkersService_1, GeoCodeService_1, CommentsService_1, AppController_1) {
    "use strict";
    var MarkerViewEventListener = (function () {
        function MarkerViewEventListener() {
        }
        MarkerViewEventListener.eventCallback = function (window) {
            ///////////////////
            //  MARKER VIEW  //
            ///////////////////
            // Open Comments Button
            window.windowContainer.find('.marker .open-comments-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                CommentsService_1.CommentsService.getCommentsForMarker(markerId, [function (MarkerData) {
                        WindowDrawer_1.WindowDrawer.drawCommentWindow(markerId, MarkerData, window);
                    }]);
            });
            // Edit Marker Button
            window.windowContainer.find('.marker .edit-marker-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                MarkersService_1.MarkersService.getMarker(markerId, [function (MarkerData) {
                        GeoCodeService_1.GeoCodeService.getGeoCodeData(MarkerData.coordinates.latitude, MarkerData.coordinates.longitude, GOOGLE_MAP_API_KEY, [function (GeoCodeData) {
                                CategoriesService_1.CategoriesService.getCategories([function (CategoriesData) {
                                        WindowDrawer_1.WindowDrawer.drawEditMarkerWindow(MarkerData, GeoCodeData, CategoriesData, window);
                                    }]);
                            }]);
                    }]);
            });
            window.windowContainer.find('.marker .tags .btn').click(function () {
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
            window.windowContainer.find('.marker .categories .btn').click(function () {
                var $this = $(this);
                var startTime = (new Date()).getTime();
                MarkersService_1.MarkersService.searchMarkersByParameters({
                    "rating": [],
                    "categories": [$this.text().trim()],
                    "tags": [],
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
            if (IS_AUTHENTICATED) {
                window.windowContainer.find('.add-remove-bookmarks-button').each(function (el) {
                    var _this = this;
                    var $this = $(this);
                    MarkersService_1.MarkersService.getBookmarkedMarkers([function (MarkersData) {
                            MarkersData.map(function (Marker) {
                                if (parseInt($this.data('marker-id')) == Marker.id)
                                    $(_this).addClass('added');
                                return Marker;
                            });
                        }]);
                });
            }
            // Add/Remove Marker To/From Bookmarks
            window.windowContainer.find('.marker .add-remove-bookmarks-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id'), added = $button.hasClass('added');
                if (IS_AUTHENTICATED) {
                    if (!added) {
                        MarkersService_1.MarkersService.addMarkerToBookmarks(markerId, [function (BD) {
                                $button.addClass('added');
                            }]);
                    }
                    else {
                        MarkersService_1.MarkersService.deleteMarkerFromBookmarks(markerId, [function (BD) {
                                $button.removeClass('added');
                            }]);
                    }
                }
                else {
                    $.toast({
                        heading: 'Войдите на ресурс',
                        icon: 'info',
                        hideAfter: false,
                        text: 'Перед тем как добавлять метки в избранное,<br>войдите на ресурс при момощи социальных сетей.<br><a class="header-button" href="/signGoogle?fallback_url=" data-base-href="/signGoogle?fallback_url=' + location.hash.substr(1) + '"><i class="fa fa-google-plus" aria-hidden="true"></i></a> <a class="header-button" href="/signFacebook?fallback_url=' + location.hash.substr(1) + '" data-base-href="/signFacebook?fallback_url="><i class="fa fa-facebook" aria-hidden="true"></i></a>',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
            // Remove Marker Button
            window.windowContainer.find('.marker .remove-marker-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                MarkersService_1.MarkersService.deleteMarker(markerId, [function (RemoveResultData) {
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
                    }, function (RemoveResultData) {
                        window.closeWindow();
                    }, function (RemoveResultData) {
                        AppController_1.AppController.instances[0].reloadMarkers();
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
        };
        return MarkerViewEventListener;
    }());
    exports.MarkerViewEventListener = MarkerViewEventListener;
});
