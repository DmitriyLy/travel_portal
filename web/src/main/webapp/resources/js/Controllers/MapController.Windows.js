var Window;
if(jQuery==="undefined"){
    console.log("Please add jQuery v2.1.4 to the page before that script.")
} else {
    (function ($) {
        $(document).ready(function () {
            Window = function (mapController, title, content, parentWindow) {
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

            MapController.mainWindow = 'mv';
            MapController.prototype.showWindow = function (window) {
                return $('<div class="window"><h2>'+window.title+'</h2><div class="content">'+window.content+'</div></div>').data('model',window).appendTo($('#windows-container'));
            };
            MapController.prototype.closeWindow = function (window) {
                window.mapController.closeChildrenWindows(window);
                window.windowContainer.remove();
                window = undefined;
            };
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