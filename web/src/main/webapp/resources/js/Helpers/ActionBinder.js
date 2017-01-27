define(["require", "exports", "../Controllers/WindowController", "../Views/CommentsView", "../Controllers/AppController", "../Views/CommentsViewHolder"], function (require, exports, WindowController_1, CommentsView_1, AppController_1, CommentsViewHolder_1) {
    "use strict";
    var ActionBinder = (function () {
        function ActionBinder() {
        }
        ActionBinder.bindActions = function (container) {
            $(container).find('.open-comments-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model'), markerId = $button.data('marker-id');
                $.get('http://nctravelportal.ddns.net/labels/' + markerId + '/comments', function (MarkerCommentsData) {
                    console.log(MarkerCommentsData);
                    new WindowController_1.WindowController(AppController_1.AppController.instances[0], 'Коментарии', new CommentsView_1.CommentsView({
                        'comments': MarkerCommentsData.map(function (comment) {
                            return (new CommentsViewHolder_1.CommentsViewHolder({
                                'id': comment.id,
                                'owner_id': comment.owner.id,
                                'owner_name': comment.owner.userName,
                                'creationDate': comment.creationDate,
                                'text': comment.text
                            })).render();
                        }).join('')
                    }), window);
                });
            });
            $(container).find('.close-window-button').click(function (event) {
                var $button = $(event.currentTarget), window = $button.parents('.window').data('model');
                window.closeWindow();
            });
        };
        return ActionBinder;
    }());
    exports.ActionBinder = ActionBinder;
});
