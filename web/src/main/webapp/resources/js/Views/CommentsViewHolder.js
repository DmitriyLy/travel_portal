var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var CommentsViewHolder = (function (_super) {
        __extends(CommentsViewHolder, _super);
        function CommentsViewHolder(params) {
            return _super.call(this, '<div class="comment col-xs-12" data-comment-id="$id$">' +
                '<div class="row">' +
                '<div class="owner col-xs-12 col-md-7 pull-left" data-owner-id="$owner_id$" title="$owner_name$">$owner_name$</div>' +
                '<div class="date col-xs-12 col-md-5 pull-right text-right">$creationDate$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12 comment-text">$text$</div>' +
                '</div>' +
                '</div>', params) || this;
        }
        return CommentsViewHolder;
    }(View_1.View));
    exports.CommentsViewHolder = CommentsViewHolder;
});
