define(["require", "exports"], function (require, exports) {
    "use strict";
    var TagsService = (function () {
        function TagsService() {
        }
        TagsService.getPopularTags = function (callbacks) {
            if (callbacks === void 0) { callbacks = []; }
            $.ajax({
                type: "GET",
                url: '/resources/tags.json',
                dataType: 'json',
                success: function (TagsData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(TagsData);
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
        return TagsService;
    }());
    exports.TagsService = TagsService;
});
