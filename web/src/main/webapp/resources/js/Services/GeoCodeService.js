define(["require", "exports"], function (require, exports) {
    "use strict";
    var GeoCodeService = (function () {
        function GeoCodeService() {
        }
        GeoCodeService.getGeoCodeData = function (latitude, longitude, key, callbacks) {
            if (callbacks === void 0) { callbacks = []; }
            $.ajax({
                type: "GET",
                url: 'https://maps.google.com/maps/api/geocode/json?latlng=' + latitude + ',' + longitude + '&sensor=false&key=' + key,
                dataType: 'json',
                success: function (MarkerGeoData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerGeoData);
                    });
                },
                error: function (error) {
                    console.log(error);
                    $.toast({
                        hideAfter: 5000,
                        heading: 'Произошла ошибка',
                        icon: 'error',
                        text: 'Произошла ошибка №' + error.status + '.<br>Более подробную информацию можно получить в консоли.<br>Просим прощения, за предоставленные неудобства.',
                        position: {
                            top: 75,
                            right: 20,
                        },
                        stack: 5
                    });
                }
            });
        };
        return GeoCodeService;
    }());
    exports.GeoCodeService = GeoCodeService;
});
