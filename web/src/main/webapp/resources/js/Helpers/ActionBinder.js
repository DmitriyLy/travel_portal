define(["require", "exports", "../Controllers/AppController", "../Views/CommentsViewHolder", "./WindowDrawer"], function (require, exports, AppController_1, CommentsViewHolder_1, WindowDrawer_1) {
    "use strict";
    var ActionBinder = (function () {
        function ActionBinder() {
        }
        ActionBinder.bindActions = function (container) {
            var _this = this;
            if (this.firstBind) {
                AppController_1.AppController.instances[0].addClickCallback(function (mapController, e) {
                    if (mapController.mode == 1) {
                        mapController.setMode(2); // edit marker
                        $.ajax({
                            type: "GET",
                            url: 'http://nctravelportal.ddns.net/reserveLabelId',
                            dataType: 'json',
                            success: function (markerId) {
                                mapController.putMarker({
                                    'latitude': e.latLng.lat(),
                                    'longtitude': e.latLng.lng(),
                                    'title': '',
                                    'id': markerId
                                });
                                var window = WindowDrawer_1.WindowDrawer.drawCreateMarkerWindow(markerId, e.latLng.lat(), e.latLng.lng());
                                window.windowContainer.data('marker', { 'id': markerId, 'latitude': e.latLng.lat(), 'longtitude': e.latLng.lng() });
                            },
                            error: function (error) { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
                        });
                    }
                });
            }
            $(container).find('.rating input[type="checkbox"]').on('change', function () {
                $(container).find('.rating input[type="checkbox"]').not(this).prop('checked', false);
            });
            $(container).find('#insert-marker').click(function () {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), marker = $button.parents('.window').data('marker');
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: 'http://nctravelportal.ddns.net/labels',
                    data: JSON.stringify({
                        'id': marker.id,
                        'coordinates': {
                            'latitude': marker.latitude,
                            'longitude': marker.longtitude
                        },
                        'address': {
                            'building': 'NODATA',
                            'street': window.windowContainer.find('.address > select').val(),
                            'city': 'NODATA',
                            'state': 'NODATA',
                            'country': 'NODATA'
                        },
                        'review': window.windowContainer.find('.review > textarea').val(),
                        'rating': window.windowContainer.find('.rating input[type=checkbox]:checked').val(),
                        'tags': window.windowContainer.find('.tags input').val().split(',').map(function (itm) { return itm.trim(); }),
                        'categories': window.windowContainer.find('.categories input').val().split(',').map(function (itm) { return itm.trim(); })
                    }),
                    dataType: 'json',
                    success: function (MarkerData) {
                        console.log(MarkerData);
                        WindowDrawer_1.WindowDrawer.drawMarkerWindow(MarkerData.id);
                    },
                    error: function (error) { console.log(error); alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
                });
            });
            $(container).find('.open-comments-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                WindowDrawer_1.WindowDrawer.drawCommentWindow(markerId, window);
            });
            $(container).find('.close-window-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model');
                // TODO: fix this
                if ($(window.windowContainer).find('.comments').length > 0) {
                    _this.pushState(location.hash.replace(/-comments/g, ''));
                }
                else if ($(window.windowContainer).find('.marker').length > 0) {
                    _this.pushState('#');
                }
                window.closeWindow();
            });
            $(container).find('#send-comment').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id'), $messageArea = $button.parents('.window').find('#comment-area');
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: 'http://nctravelportal.ddns.net/labels/' + markerId + '/comments',
                    data: JSON.stringify({
                        "text": $messageArea.val()
                    }),
                    dataType: 'json',
                    success: function (CommentData) {
                        $(".comments > .comments-list").prepend((new CommentsViewHolder_1.CommentsViewHolder({
                            'id': CommentData.id,
                            'owner_name': CommentData.owner.userName,
                            'owner_id': CommentData.owner.id,
                            'creationDate': CommentData.creationDate,
                            'text': CommentData.text,
                        })).render());
                    },
                    error: function (error) { alert("Произошла ошибка, пожалуйста, попробуйте позже."); }
                });
            });
            if ($(container).find('.attachments a').length > 0) {
                $(container).find('.attachments a').featherlightGallery({
                    gallery: {
                        fadeIn: 300,
                        fadeOut: 300
                    },
                    openSpeed: 300,
                    closeSpeed: 300
                });
            }
            this.firstBind = false;
        };
        ActionBinder.pushState = function (state) {
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
