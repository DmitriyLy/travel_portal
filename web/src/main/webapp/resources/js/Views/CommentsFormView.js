var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var CommentsFormView = (function (_super) {
        __extends(CommentsFormView, _super);
        function CommentsFormView(params) {
            return _super.call(this, '<div class="col-xs-12 text-left">Оставьте коментарий:</div>' +
                '<div class="col-xs-12 text-center"><textarea id="comment-area"></textarea></div>' +
                '<div class="col-xs-12 text-right"><button class="btn btn-default" id="send-comment" data-marker-id="$marker_id$">Написать</button></div>', params) || this;
        }
        return CommentsFormView;
    }(View_1.View));
    exports.CommentsFormView = CommentsFormView;
});
