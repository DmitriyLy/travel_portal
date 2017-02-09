define(["require", "exports", "../Controllers/AppController", "./WindowDrawer", "../Services/MarkersService", "../Services/CategoriesService", "../Services/GeoCodeService", "../Services/TagsService"], function (require, exports, AppController_1, WindowDrawer_1, MarkersService_1, CategoriesService_1, GeoCodeService_1, TagsService_1) {
    "use strict";
    var ActionBinder = (function () {
        function ActionBinder() {
        }
        ActionBinder.bindActions = function (container) {
            if (this.firstBind) {
                AppController_1.AppController.instances[0].addClickCallback(function (mapController, e) {
                    if (mapController.mode == 1) {
                        mapController.setMode(0);
                        $('#map').addClass('inactive');
                        AppController_1.AppController.instances[0].map.setZoom(18);
                        AppController_1.AppController.instances[0].map.setCenter(new google.maps.LatLng(e.latLng.lat(), e.latLng.lng()));
                        MarkersService_1.MarkersService.reserveMarkerId([function (markerId) {
                                mapController.putMarker({
                                    'latitude': e.latLng.lat(),
                                    'longitude': e.latLng.lng(),
                                    'title': '',
                                    'id': markerId
                                });
                                GeoCodeService_1.GeoCodeService.getGeoCodeData(e.latLng.lat(), e.latLng.lng(), GOOGLE_MAP_API_KEY, [function (GeoCodeData) {
                                        CategoriesService_1.CategoriesService.getCategories([function (CategoriesData) {
                                                WindowDrawer_1.WindowDrawer.drawCreateMarkerWindow({
                                                    'id': markerId,
                                                    'latitude': e.latLng.lat(),
                                                    'longitude': e.latLng.lng()
                                                }, GeoCodeData, CategoriesData);
                                            }]);
                                    }]);
                            }]);
                    }
                });
                $('#show-my-bookmarked-markers').click(function (event) {
                    $('#map').removeClass('inactive');
                    MarkersService_1.MarkersService.getBookmarkedMarkers([function (MarkersData) {
                            WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Избранные метки', MarkersData, 'favourites');
                            ActionBinder.pushState('#favourites');
                        }]);
                });
                $('#show-my-markers').click(function (event) {
                    $('#map').removeClass('inactive');
                    MarkersService_1.MarkersService.getMyMarkers([function (MarkersData) {
                            WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Мои метки', MarkersData, 'my-markers');
                            ActionBinder.pushState('#my-markers');
                        }]);
                });
                $('#show-search').click(function (event) {
                    $('#map').removeClass('inactive');
                    CategoriesService_1.CategoriesService.getCategories([function (CategoriesData) {
                            TagsService_1.TagsService.getPopularTags([function (TagsData) {
                                    WindowDrawer_1.WindowDrawer.drawSearchWindow(CategoriesData, TagsData);
                                }]);
                        }]);
                });
                $('#show-my-comments').click(function (event) {
                    $('#map').removeClass('inactive');
                    MarkersService_1.MarkersService.getCommentedMarkers([function (MarkersData) {
                            WindowDrawer_1.WindowDrawer.drawMarkersListWindow('Мои Комментарии', MarkersData, 'my-comments');
                            ActionBinder.pushState('#my-comments');
                        }]);
                });
                $('[data-click-id]').click(function (event) {
                    var $this = $(this);
                    $('#' + $this.data('click-id')).click();
                });
            }
            this.firstBind = false;
        };
        ActionBinder.pushState = function (state) {
            $('#header-menu [data-base-href]').each(function () {
                var $this = $(this);
                console.log(($this.data('base-href') + state.substr(1)));
                $this.attr('href', ($this.data('base-href') + state.substr(1)));
            });
            if (history.pushState) {
                history.pushState(null, null, state);
            }
            else {
                location.hash = state;
            }
        };
        return ActionBinder;
    }());
    ActionBinder.firstBind = true;
    exports.ActionBinder = ActionBinder;
});
