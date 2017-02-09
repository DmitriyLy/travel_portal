define(["require", "exports"], function (require, exports) {
    "use strict";
    var CommentsService = (function () {
        function CommentsService() {
        }
        CommentsService.getCommentsForMarker = function (id, callbacks) {
            $.ajax({
                type: "GET",
                url: '/labels/' + id + '/comments',
                dataType: 'json',
                success: function (MarkerCommentsData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerCommentsData);
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
        CommentsService.deleteComment = function (MarkerId, CommentId, callbacks) {
            $.ajax({
                type: "DELETE",
                url: '/labels/' + MarkerId + '/comments/' + CommentId,
                success: function (MarkerData) {
                    callbacks.forEach(function (callback, i, arr) {
                        callback(MarkerData);
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
        return CommentsService;
    }());
    exports.CommentsService = CommentsService;
});
