define(["require", "exports", "../Helpers/ActionBinder"], function (require, exports, ActionBinder_1) {
    "use strict";
    var WindowEventListener = (function () {
        function WindowEventListener() {
        }
        WindowEventListener.eventCallback = function (window) {
            ///////////////////
            //    WINDOW     //
            ///////////////////
            // Close Window Button
            window.windowContainer.find('.close-window-button').click(function (event) {
                if (window.parentWindow == undefined) {
                    ActionBinder_1.ActionBinder.pushState('#');
                    window.closeWindow();
                    return;
                }
                if (window.parentWindow.windowContainer.find('.marker .open-comments-button').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#marker-' + window.parentWindow.windowContainer.find('.marker .open-comments-button').data('marker-id'));
                }
                if (window.parentWindow.windowContainer.find('.comments').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#marker-comments-' + window.parentWindow.windowContainer.find('#send-comment').data('marker-id'));
                }
                if (window.parentWindow.windowContainer.find('.search').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#search');
                }
                if (window.parentWindow.windowContainer.find('.marker-list.search-list').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#search');
                }
                if (window.parentWindow.windowContainer.find('.marker-list.favourites').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#favourites');
                }
                if (window.parentWindow.windowContainer.find('.marker-list.my-markers').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#my-markers');
                }
                if (window.parentWindow.windowContainer.find('.marker-list.my-comments').length > 0) {
                    ActionBinder_1.ActionBinder.pushState('#my-comments');
                }
                //
                // // TODO: fix this
                // if(window.windowContainer.find('.comments').length > 0) {
                //     ActionBinder.pushState(location.hash.replace(/-comments/g,''));
                // } else if(window.parentWindow.windowContainer.find('.marker').length > 0) {
                //     ActionBinder.pushState('#');
                // }
                window.closeWindow();
            });
        };
        return WindowEventListener;
    }());
    exports.WindowEventListener = WindowEventListener;
});
