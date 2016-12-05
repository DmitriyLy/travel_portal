var WindowController;
if(jQuery==="undefined"){
    console.log("Please add jQuery v2.1.4 to the page before that script.")
} else {
    (function ($) {
        $(document).ready(function () {
            /***
             * Creates window.
             */
            WindowController = function (mapController, title, content, parentWindow) {
                this.title = title;
                this.content = content;
                this.childrenWindows = [];
                this.mapController = mapController;
                if(typeof parentWindow !== "undefined") {
                    this.mapController.closeChildrenWindows(parentWindow);
                    this.parentWindow = parentWindow;
                    this.parentWindow.childrenWindows.push(this);
                } else {
                    if(typeof mapController.mainWindow !== "undefined")
                        mapController.mainWindow.mapController.closeWindow(mapController.mainWindow);
                    mapController.mainWindow = this;
                }
                this.windowContainer = this.mapController.showWindow(this);
                return this;
            };

            /***
             * Shows window.
             */
            MapController.prototype.showWindow = function (window) { // TODO: add view files
                return $('<div class="window"><h2>'+window.title+'</h2><div class="content">'+window.content+'</div></div>').data('model',window).appendTo($('#windows-container'));
            };

            /***
             * Closes window.
             */
            MapController.prototype.closeWindow = function (window) {
                window.mapController.closeChildrenWindows(window);
                window.windowContainer.remove();
                window = undefined;
            };

            /***
             * Closes children windows.
             */
            MapController.prototype.closeChildrenWindows = function (window) {
                if(window.childrenWindows.length>0) {
                    window.childrenWindows.forEach(function(childrenWindow, i, arr) {
                        childrenWindow.mapController.closeWindow(childrenWindow);
                    });
                }
            };
        });
    })(jQuery);
}