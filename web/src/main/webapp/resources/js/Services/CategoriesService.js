define(["require", "exports"], function (require, exports) {
    "use strict";
    var CategoriesService = (function () {
        function CategoriesService() {
        }
        CategoriesService.getCategories = function (callbacks) {
            if (callbacks === void 0) { callbacks = []; }
            $.ajax({
                type: "GET",
                url: '/categories',
                dataType: 'json',
                success: function (CategoriesData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(CategoriesData);
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
        return CategoriesService;
    }());
    exports.CategoriesService = CategoriesService;
});
