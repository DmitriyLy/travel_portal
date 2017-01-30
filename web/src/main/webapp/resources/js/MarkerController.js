var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "../Views/View", "./WindowController"], function (require, exports, View_1, WindowController_1) {
    "use strict";
    var MarkerController = (function (_super) {
        __extends(MarkerController, _super);
        /***
         * Creates window.
         */
        function MarkerController(mapController, windowView, title, content, parentWindow) {
            if (parentWindow === void 0) { parentWindow = null; }
            this.childrenWindows = [];
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
        MarkerController.prototype.showWindow = function () {
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
        MarkerController.prototype.closeWindow = function () {
            this.closeChildrenWindows();
            $(this.windowContainer).remove();
        };
        /***
         * Closes children windows.
         */
        MarkerController.prototype.closeChildrenWindows = function () {
            if (this.childrenWindows.length > 0) {
                this.childrenWindows.forEach(function (childrenWindow, i, arr) {
                    childrenWindow.closeWindow();
                });
            }
        };
        return MarkerController;
    }(WindowController_1.WindowController));
    exports.MarkerController = MarkerController;
});
