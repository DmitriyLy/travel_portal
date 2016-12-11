define(["require", "exports", "../Views/View"], function (require, exports, View_1) {
    "use strict";
    var WindowController = (function () {
        /***
         * Creates window.
         */
        function WindowController(mapController, windowView, title, content, parentWindow) {
            if (parentWindow === void 0) { parentWindow = null; }
            this.childrenWindows = [];
            this.title = title;
            this.content = content;
            this.mapController = mapController;
            if (parentWindow != null) {
                parentWindow.closeChildrenWindows();
                this.parentWindow = parentWindow;
                this.parentWindow.childrenWindows.push(this);
            }
            else {
                if (mapController.mainWindow != null)
                    mapController.mainWindow.closeWindow();
                mapController.mainWindow = this;
            }
            this.windowView = windowView;
            this.windowContainer = this.showWindow();
            return this;
        }
        /***
         * Shows window.
         */
        WindowController.prototype.showWindow = function () {
            if (this.windowView == null)
                return "";
            return $(this.windowView.render({
                "title": this.title,
                "content": this.content instanceof View_1.View ? this.content.render() : this.content
            })).data('model', this).appendTo($('#windows-container'));
            // WindowView.render({
            //     "title":this.title,
            //     "content":MarkerView.render({
            //         "user":"User",
            //         "date":"13.10.1995",
            //         "rate":"5",
            //         "content":"Lorem ipsum text",
            //         "comments":"None"
            //     })
            // })
        };
        /***
         * Closes window.
         */
        WindowController.prototype.closeWindow = function () {
            this.closeChildrenWindows();
            $(this.windowContainer).remove();
        };
        /***
         * Closes children windows.
         */
        WindowController.prototype.closeChildrenWindows = function () {
            if (this.childrenWindows.length > 0) {
                this.childrenWindows.forEach(function (childrenWindow, i, arr) {
                    childrenWindow.closeWindow();
                });
            }
        };
        return WindowController;
    }());
    exports.WindowController = WindowController;
});
