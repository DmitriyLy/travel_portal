define(["require", "exports", "../Views/WindowView", "../Views/View"], function (require, exports, WindowView_1, View_1) {
    "use strict";
    var WindowController = (function () {
        /***
         * Creates window.
         */
        function WindowController(mapController, title, content, parentWindow) {
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
            this.windowContainer = this.showWindow();
            this.afterCreate();
            return this;
        }
        /***
         * Shows window.
         */
        WindowController.prototype.showWindow = function () {
            return $(new WindowView_1.WindowView({
                "title": this.title,
                "content": this.content instanceof View_1.View ? this.content.render() : this.content
            }).render()).data('model', this).appendTo($('#windows-container'));
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
        WindowController.bindAfterCreate = function (callback) {
            if (typeof callback !== "function")
                return;
            WindowController.afterCreateCallbacks.push(callback);
        };
        WindowController.prototype.afterCreate = function () {
            var _this = this;
            WindowController.afterCreateCallbacks.forEach(function (callback, i, arr) {
                callback(_this);
            });
        };
        return WindowController;
    }());
    WindowController.afterCreateCallbacks = [];
    exports.WindowController = WindowController;
});
