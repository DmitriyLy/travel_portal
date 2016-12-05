if(jQuery==="undefined"){
    console.log("Please add jQuery v2.1.4 to the page before that script.")
} else {
    (function ($) {
        $(document).ready(function() {
            $.material.init();
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

            $('#open-sidebar-menu').click(function(){
                console.log("#open-sidebar-menu click");
                var inter = setInterval(function(){
                    $(window).resize();
                    console.log("resized");
                },32);
                setTimeout(function(){
                    clearInterval(inter);
                },2000);
            });


            // /* GOOGLE MAP SEGMENT */
            // var initMap = function() {
            //     var mapOptions = {
            //         zoom: 11,
            //         center: new google.maps.LatLng(40.6700, -73.9400),
            //         disableDefaultUI: true,
            //         //styles: [{"featureType":"all","elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#000000"},{"lightness":40}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#000000"},{"lightness":16}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":17},{"weight":1.2}]},{"featureType":"administrative.country","elementType":"labels.text","stylers":[{"color":"#fb7f41"},{"weight":"0.01"}]},{"featureType":"administrative.locality","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"administrative.neighborhood","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.fill","stylers":[{"lightness":"17"}]},{"featureType":"administrative.land_parcel","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"landscape","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"landscape.man_made","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"landscape.man_made","elementType":"labels.text","stylers":[{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":21},{"visibility":"off"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"simplified"}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"visibility":"on"},{"color":"#ff4700"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"lightness":17}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":29},{"weight":0.2}]},{"featureType":"road.highway","elementType":"labels","stylers":[{"invert_lightness":true},{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#3b3b3b"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":18}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"color":"#ff4700"},{"lightness":"39"},{"gamma":"0.43"},{"saturation":"-47"}]},{"featureType":"road.arterial","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":16}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"color":"#555555"}]},{"featureType":"road.local","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":19}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":17}]}]
            //         styles: [{"featureType":"landscape","elementType":"geometry","stylers":[{"saturation":"-100"}]},{"featureType":"poi","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road","elementType":"labels.text","stylers":[{"color":"#545454"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"saturation":"-87"},{"lightness":"-40"},{"color":"#ffffff"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.fill","stylers":[{"color":"#f0f0f0"},{"saturation":"-22"},{"lightness":"-16"}]},{"featureType":"road.highway.controlled_access","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway.controlled_access","elementType":"labels.icon","stylers":[{"visibility":"on"}]},{"featureType":"road.arterial","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.local","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"geometry.fill","stylers":[{"saturation":"-52"},{"hue":"#00e4ff"},{"lightness":"-16"}]}]
            //     };
            //
            //     var mapElement = document.getElementById('map');
            //
            //     var map = new google.maps.Map(mapElement, mapOptions);
            //
            //     var marker = new google.maps.Marker({
            //         position: new google.maps.LatLng(40.6700, -73.9400),
            //         map: map,
            //         title: 'Snazzy!'
            //     });
            // };
            // initMap();
            // $('#actions-container ')
            var fabMouseHoverCallback = function ($this,dataSrc) {
                var $button = $this.find('.toggle-icon'),
                    $el = $button.find('i.material-icons');
                $( $el ).animate({
                    opacity: 0
                }, 125, function() {
                    $el.text($button.data(dataSrc));
                    $( $el ).animate({
                        opacity: 1
                    }, 125);
                });
            };
            $('#actions-container').mouseenter(function () {
                fabMouseHoverCallback($(this),'hover-icon');
            }).mouseleave(function () {
                fabMouseHoverCallback($(this),'std-icon');
            });

            var testMap = function () {
                setTimeout(function () {
                    var markers = [];
                    setTimeout(function () {
                        markers.push(MapSingletone.putMarker({
                            latitude:40.6700,
                            longtitude:-73.9400
                        }));
                        setTimeout(function () {
                            markers.push(MapSingletone.putMarker({
                                latitude:40.7700,
                                longtitude:-73.9400
                            }));
                            setTimeout(function () {
                                markers.push(MapSingletone.putMarker({
                                    latitude:40.5700,
                                    longtitude:-73.9400
                                }));
                                setTimeout(function () {
                                    markers.push(MapSingletone.putMarker({
                                        latitude:40.6700,
                                        longtitude:-73.8400
                                    }));
                                    setTimeout(function () {
                                        markers.push(MapSingletone.putMarker({
                                            latitude:40.6700,
                                            longtitude:-74.0400
                                        }));
                                    },400);
                                },400);
                            },400);
                        },400);
                    },1);
                    setTimeout(function () {
                        MapSingletone.removeMarker(markers[0]);
                        setTimeout(function () {
                            MapSingletone.removeMarker(markers[1]);
                            setTimeout(function () {
                                MapSingletone.removeMarker(markers[2]);
                                setTimeout(function () {
                                    MapSingletone.removeMarker(markers[3]);
                                    setTimeout(function () {
                                        MapSingletone.removeMarker(markers[4]);
                                    },200);
                                },200);
                            },200);
                        },200);
                    },2000);
                    setTimeout(function () {
                        var wnd1 = new WindowController(MapSingletone, 'First WindowController', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, ');
                        setTimeout(function () {
                            var wnd2 = new WindowController(MapSingletone, 'Second WindowController', 'Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.', wnd1);
                            setTimeout(function () {
                                var wnd3 = new WindowController(MapSingletone, 'Third WindowController', 'Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum.', wnd2);
                                setTimeout(function () {
                                    var wnd4 = new WindowController(MapSingletone, 'Fourth WindowController', 'Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.', wnd3);
                                },400);
                            },400);
                        },400);
                        setTimeout(function () {
                            MapSingletone.closeWindow(wnd1);
                        },1600);

                    },4000);
                },200);
            };

            $('#addMarkerButton').click(function () {
                testMap();

                MapSingletone.reloadMarkers();
            });

            $('#zoom-in-button').click(function () {
                var zoom = MapSingletone.map.getZoom() + 1;
                if(zoom>20)
                    zoom = 20;
                MapSingletone.map.setZoom(zoom);
            });
            $('#zoom-out-button').click(function () {
                var zoom = MapSingletone.map.getZoom() - 1;
                if(zoom<2)
                    zoom = 2;
                MapSingletone.map.setZoom(zoom);
            })
        });
    })(jQuery);
}
