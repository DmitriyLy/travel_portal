define(["require", "exports", "./AppController", "./WindowController", "../Views/MarkerView"], function (require, exports, AppController_1, WindowController_1, MarkerView_1) {
    "use strict";
    var FloatingButtonsEventController = (function () {
        function FloatingButtonsEventController() {
        }
        FloatingButtonsEventController.fabMouseHoverCallback = function ($this, dataSrc) {
            var $button = $this.find('.toggle-icon'), $el = $button.find('i.material-icons');
            $($el).animate({
                opacity: 0
            }, 125, function () {
                $el.text($button.data(dataSrc));
                $($el).animate({
                    opacity: 1
                }, 125);
            });
        };
        FloatingButtonsEventController.init = function () {
            var _this = this;
            $('#actions-container').mouseenter(function (el) {
                var $this = $(el.currentTarget);
                _this.fabMouseHoverCallback($this, 'hover-icon');
            }).mouseleave(function (el) {
                var $this = $(el.currentTarget);
                _this.fabMouseHoverCallback($this, 'std-icon');
            });
            $('#addMarkerButton').click(function () {
                // Test
                _this.testMap();
                AppController_1.AppController.instances[0].reloadMarkers();
            });
            $('#zoom-in-button').click(function () {
                var zoom = AppController_1.AppController.instances[0].map.getZoom() + 1;
                if (zoom > 20)
                    zoom = 20;
                AppController_1.AppController.instances[0].map.setZoom(zoom);
            });
            $('#zoom-out-button').click(function () {
                var zoom = AppController_1.AppController.instances[0].map.getZoom() - 1;
                if (zoom < 2)
                    zoom = 2;
                AppController_1.AppController.instances[0].map.setZoom(zoom);
            });
        };
        FloatingButtonsEventController.testMap = function () {
            $.get('http://nctravelportal.ddns.net/labels/3', function (MarkerData) {
                new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'О Метке', new MarkerView_1.MarkerView({
                    "marker_id": MarkerData.id,
                    "owner_id": MarkerData.owner.id,
                    "owner_name": MarkerData.owner.userName,
                    "creationDate": MarkerData.creationDate,
                    "address": MarkerData.address.country + ", " +
                        MarkerData.address.state + ". " +
                        MarkerData.address.city + ". " +
                        MarkerData.address.street + ", " +
                        MarkerData.address.building,
                    "rating": MarkerData.rating,
                    "review": MarkerData.review,
                    "categories": MarkerData.categories.map(function (itm) { return "<button class='btn btn-success'>" + itm + "</button>"; }).join(' '),
                    "tags": MarkerData.tags.map(function (itm) { return "<button class='btn btn-primary'>" + itm + "</button>"; }).join(' '),
                    "attachments": MarkerData.attachments.map(function (itm) { return "<a href='" + itm.name + "'><img src='" + itm.name + "'/></a>"; }).join(''),
                    "commentCount": MarkerData.commentCount
                }));
            });
            // setTimeout(function () {
            //     var markers = [];
            //     setTimeout(function () {
            //         markers.push(AppController.instances[0].putMarker({
            //             latitude:40.6700,
            //             longtitude:-73.9400
            //         }));
            //         setTimeout(function () {
            //             markers.push(AppController.instances[0].putMarker({
            //                 latitude:40.7700,
            //                 longtitude:-73.9400
            //             }));
            //             setTimeout(function () {
            //                 markers.push(AppController.instances[0].putMarker({
            //                     latitude:40.5700,
            //                     longtitude:-73.9400
            //                 }));
            //                 setTimeout(function () {
            //                     markers.push(AppController.instances[0].putMarker({
            //                         latitude:40.6700,
            //                         longtitude:-73.8400
            //                     }));
            //                     setTimeout(function () {
            //                         markers.push(AppController.instances[0].putMarker({
            //                             latitude:40.6700,
            //                             longtitude:-74.0400
            //                         }));
            //                     },400);
            //                 },400);
            //             },400);
            //         },400);
            //     },1);
            //     setTimeout(function () {
            //         AppController.instances[0].removeMarker(markers[0]);
            //         setTimeout(function () {
            //             AppController.instances[0].removeMarker(markers[1]);
            //             setTimeout(function () {
            //                 AppController.instances[0].removeMarker(markers[2]);
            //                 setTimeout(function () {
            //                     AppController.instances[0].removeMarker(markers[3]);
            //                     setTimeout(function () {
            //                         AppController.instances[0].removeMarker(markers[4]);
            //                     },200);
            //                 },200);
            //             },200);
            //         },200);
            //     },2000);
            //     setTimeout(function () {
            //         var tmpView = new WindowView();
            //         var wnd1 = new WindowController(AppController.instances[0], tmpView, 'First WindowController', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, ');
            //         setTimeout(function () {
            //             var wnd2 = new WindowController(AppController.instances[0], tmpView, 'Second WindowController', 'Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.', wnd1);
            //             setTimeout(function () {
            //                 var wnd3 = new WindowController(AppController.instances[0], tmpView, 'Third WindowController', 'Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum.', wnd2);
            //                 setTimeout(function () {
            //                     var wnd4 = new WindowController(AppController.instances[0], tmpView, 'Fourth WindowController', 'Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.', wnd3);
            //                 },400);
            //             },400);
            //         },400);
            //         setTimeout(function () {
            //             wnd1.closeWindow();
            //         },1600);
            //     },4000);
            // },200);
        };
        FloatingButtonsEventController.styles = {};
        return FloatingButtonsEventController;
    }());
    exports.FloatingButtonsEventController = FloatingButtonsEventController;
});
