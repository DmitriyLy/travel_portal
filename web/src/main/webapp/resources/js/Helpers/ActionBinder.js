define(["require", "exports", "./WindowDrawer"], function (require, exports, WindowDrawer_1) {
    "use strict";
    var ActionBinder = (function () {
        function ActionBinder() {
        }
        ActionBinder.bindActions = function (container) {
            var _this = this;
            $(container).find('#addMarkerButton').click(function (event) {
                var $marker = $(event.currentTarget), markerId = 3;
                // markerId : number = $button.data('marker-id');
                WindowDrawer_1.WindowDrawer.drawMarkerWindow(markerId);
            });
            $(container).find('.open-comments-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                WindowDrawer_1.WindowDrawer.drawCommentWindow(markerId, window);
            });
            $(container).find('.close-window-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model');
                console.log($(window.windowContainer).find('.marker'));
                // TODO: fix this
                if ($(window.windowContainer).find('.comments').length > 0) {
                    _this.pushState(location.hash.replace(/-comments/g, ''));
                }
                else if ($(window.windowContainer).find('.marker').length > 0) {
                    _this.pushState('#');
                }
                window.closeWindow();
            });
            $(container).find('.attachments a').featherlightGallery({
                gallery: {
                    fadeIn: 300,
                    fadeOut: 300
                },
                openSpeed: 300,
                closeSpeed: 300
            });
        };
        ActionBinder.pushState = function (state) {
            if (history.pushState) {
                history.pushState(null, null, state);
            }
            else {
                location.hash = state;
            }
        };
        ActionBinder.firstBind = true;
        return ActionBinder;
    }());
    exports.ActionBinder = ActionBinder;
});
