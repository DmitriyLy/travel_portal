import {AppController} from "./AppController";
import {WindowController} from "./WindowController";
import {WindowView} from "../Views/WindowView";
declare var $:JQueryStatic|any;

export class FloatingButtonsEventController {
    static styles : any = {};
    static fabMouseHoverCallback($this, dataSrc) {
        var $button = $this.find('.toggle-icon'),
            $el = $button.find('i.material-icons');
        $( $el ).animate({
            opacity: 0
        }, 125, () => {
            $el.text($button.data(dataSrc));
            $( $el ).animate({
                opacity: 1
            }, 125);
        });
    }
    static init() {
        $('#actions-container').mouseenter((el) => {
            var $this = $(el.currentTarget);
            this.fabMouseHoverCallback($this,'hover-icon');
        }).mouseleave((el) => {
            var $this = $(el.currentTarget);
            this.fabMouseHoverCallback($this,'std-icon');
        });
        $('#addMarkerButton').click(() => {
            // Test
            this.testMap();
            AppController.instances[0].reloadMarkers();
        });
        $('#zoom-in-button').click(() => {
            var zoom = AppController.instances[0].map.getZoom() + 1;
            if(zoom>20)
                zoom = 20;
            AppController.instances[0].map.setZoom(zoom);
        });
        $('#zoom-out-button').click(() => {
            var zoom = AppController.instances[0].map.getZoom() - 1;
            if(zoom<2)
                zoom = 2;
            AppController.instances[0].map.setZoom(zoom);
        });
    }

    static testMap() {
        setTimeout(function () {
            var markers = [];
            setTimeout(function () {
                markers.push(AppController.instances[0].putMarker({
                    latitude:40.6700,
                    longtitude:-73.9400
                }));
                setTimeout(function () {
                    markers.push(AppController.instances[0].putMarker({
                        latitude:40.7700,
                        longtitude:-73.9400
                    }));
                    setTimeout(function () {
                        markers.push(AppController.instances[0].putMarker({
                            latitude:40.5700,
                            longtitude:-73.9400
                        }));
                        setTimeout(function () {
                            markers.push(AppController.instances[0].putMarker({
                                latitude:40.6700,
                                longtitude:-73.8400
                            }));
                            setTimeout(function () {
                                markers.push(AppController.instances[0].putMarker({
                                    latitude:40.6700,
                                    longtitude:-74.0400
                                }));
                            },400);
                        },400);
                    },400);
                },400);
            },1);
            setTimeout(function () {
                AppController.instances[0].removeMarker(markers[0]);
                setTimeout(function () {
                    AppController.instances[0].removeMarker(markers[1]);
                    setTimeout(function () {
                        AppController.instances[0].removeMarker(markers[2]);
                        setTimeout(function () {
                            AppController.instances[0].removeMarker(markers[3]);
                            setTimeout(function () {
                                AppController.instances[0].removeMarker(markers[4]);
                            },200);
                        },200);
                    },200);
                },200);
            },2000);
            setTimeout(function () {
                var tmpView = new WindowView();
                var wnd1 = new WindowController(AppController.instances[0], tmpView, 'First WindowController', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, ');
                setTimeout(function () {
                    var wnd2 = new WindowController(AppController.instances[0], tmpView, 'Second WindowController', 'Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.', wnd1);
                    setTimeout(function () {
                        var wnd3 = new WindowController(AppController.instances[0], tmpView, 'Third WindowController', 'Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum.', wnd2);
                        setTimeout(function () {
                            var wnd4 = new WindowController(AppController.instances[0], tmpView, 'Fourth WindowController', 'Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt.', wnd3);
                        },400);
                    },400);
                },400);
                setTimeout(function () {
                    wnd1.closeWindow();
                },1600);
            },4000);
        },200);
    }
}