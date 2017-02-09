define(["require", "exports", "../Views/CommentsViewHolder", "../Services/CommentsService"], function (require, exports, CommentsViewHolder_1, CommentsService_1) {
    "use strict";
    var CommentsEventListener = (function () {
        function CommentsEventListener() {
        }
        CommentsEventListener.eventCallback = function (window) {
            // Validation
            if (window.windowContainer.find('#CommentsForm').length > 0) {
                $("#CommentsForm").validate({
                    rules: {
                        'comment-area': {
                            required: true,
                            minlength: 2,
                            maxlength: 2000
                        }
                    },
                    messages: {
                        'comment-area': {
                            required: "Пожалуйста, введите сообщение.",
                            minlength: "Ваше сообщение должно состоять минимум из 2 символов.",
                            maxlength: "Ваще сообщение должно состоять максимум из 2000 символов."
                        }
                    },
                    errorElement: "em",
                    errorPlacement: function (error, element) {
                        error.addClass("help-block");
                        element.parents(".col-sm-5").addClass("has-feedback");
                        if (element.prop("type") === "checkbox") {
                            error.insertAfter(element.parent("label"));
                        }
                        else {
                            error.insertAfter(element);
                        }
                        if (!element.next("span")[0]) {
                            $("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
                        }
                    },
                    success: function (label, element) {
                        // Add the span element, if doesn't exists, and apply the icon classes to it.
                        if (!$(element).next("span")[0]) {
                            $("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
                        }
                    },
                    highlight: function (element, errorClass, validClass) {
                        $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
                        $(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
                        $(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
                    }
                });
            }
            // Send Comment Button
            window.windowContainer.find('#send-comment').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id'), $messageArea = $button.parents('.window').find('#comment-area');
                if ($("#CommentsForm").valid()) {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: '/labels/' + markerId + '/comments',
                        data: JSON.stringify({
                            "text": $messageArea.val()
                        }),
                        dataType: 'json',
                        success: function (CommentData) {
                            var Comment = $((new CommentsViewHolder_1.CommentsViewHolder({
                                'id': CommentData.id,
                                'owner_name': CommentData.owner.userName,
                                'owner_id': CommentData.owner.id,
                                'creationDate': CommentData.creationDate,
                                'text': CommentData.text,
                                'actions_visibility': CommentData.owner.id == USER_ID ? '' : 'hidden',
                                'marker_id': markerId
                            })).render()).prependTo($(".comments > .comments-list"));
                            $.toast({
                                hideAfter: 5000,
                                heading: 'Комментарий сохранён',
                                icon: 'info',
                                text: 'Ваш комментарий сохранён.',
                                position: {
                                    top: 75,
                                    right: 20,
                                },
                                stack: 5
                            });
                            $(Comment).find('.remove-comment').click(function (event) {
                                CommentsService_1.CommentsService.deleteComment(markerId, CommentData.id, [function (RemoveCommentData) {
                                        Comment.remove();
                                    }, function (RemoveCommentData) {
                                        $.toast({
                                            hideAfter: 5000,
                                            heading: 'Комментарий удалён',
                                            icon: 'info',
                                            text: 'Ваш комментарий удалён.',
                                            position: {
                                                top: 75,
                                                right: 20,
                                            },
                                            stack: 5
                                        });
                                    }]);
                            });
                            $button.parents('.window').find('#comment-area').val("");
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
                }
            });
            // Delete Comment Button
            window.windowContainer.find('.comments .remove-comment').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), MarkerId = $button.data('marker-id'), CommentId = $button.data('comment-id');
                CommentsService_1.CommentsService.deleteComment(MarkerId, CommentId, [function (RemoveCommentData) {
                        $button.parents('.comment').remove();
                    }, function (RemoveCommentData) {
                        $.toast({
                            hideAfter: 5000,
                            heading: 'Комментарий удалён',
                            icon: 'info',
                            text: 'Ваш комментарий удалён.',
                            position: {
                                top: 75,
                                right: 20,
                            },
                            stack: 5
                        });
                    }]);
                // '+MarkerId+'
            });
        };
        return CommentsEventListener;
    }());
    exports.CommentsEventListener = CommentsEventListener;
});
