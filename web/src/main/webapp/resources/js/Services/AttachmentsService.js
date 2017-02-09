define(["require", "exports"], function (require, exports) {
    "use strict";
    var AttachmentsService = (function () {
        function AttachmentsService() {
        }
        AttachmentsService.deleteAttachment = function (MarkerId, AttachmentId, callbacks) {
            $.ajax({
                type: "DELETE",
                url: '/labels/' + MarkerId + '/attachments/' + AttachmentId,
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
        return AttachmentsService;
    }());
    exports.AttachmentsService = AttachmentsService;
});
