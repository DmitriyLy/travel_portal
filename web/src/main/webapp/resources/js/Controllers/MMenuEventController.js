define(["require", "exports"], function (require, exports) {
    "use strict";
    var MMenuEventController = (function () {
        function MMenuEventController() {
        }
        MMenuEventController.init = function () {
            $("#menu").mmenu({
                "extensions": [
                    "pagedim-black",
                    "theme-dark",
                    "border-offset",
                    "effect-menu-slide",
                    "effect-panels-slide-100",
                    "effect-listitems-slide",
                    "shadow-page",
                    "shadow-panels"
                ],
                "counters": true
            });
            // 30FPS Map Resizing Fix for MMenu module
            $('#open-sidebar-menu').click(function () {
                var inter = setInterval(function () {
                    $(window).resize();
                }, 32);
                setTimeout(function () {
                    clearInterval(inter);
                }, 2000);
            });
            // END
        };
        return MMenuEventController;
    }());
    exports.MMenuEventController = MMenuEventController;
});
