declare var $:JQueryStatic|any;
export class MMenuEventController {
    static init() {
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
        $('#open-sidebar-menu').click(() => {
            var inter = setInterval(() => {
                $(window).resize();
            },32);
            setTimeout(() => {
                clearInterval(inter);
            },2000);
        });
        // END
    }
}