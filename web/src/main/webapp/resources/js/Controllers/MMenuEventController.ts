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
            "counters": true,
            "navbars": [
                {
                    "position": "top",
                    "content": [
                        "searchfield"
                    ]
                },
                {
                    "position": "bottom",
                    "content": [
                        "<a class='fa fa-envelope' href='#/'></a>",
                        "<a class='fa fa-twitter' href='#/'></a>",
                        "<a class='fa fa-facebook' href='#/'></a>"
                    ]
                }
            ]
        });

        // 30FPS Map Resizing Fix for MMenu module
        $('#open-sidebar-menu').click(() => {
            var inter = setInterval(() => {
                $(window).resize();
                console.log("resized");
            },32);
            setTimeout(() => {
                clearInterval(inter);
            },2000);
        });
        // END
    }
}