var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var CommentsView = (function (_super) {
        __extends(CommentsView, _super);
        function CommentsView(params) {
            _super.call(this, '<div class="comments">' +
                '<div class="comments-list row">$comments$</div>' +
                '</div>', params);
        }
        return CommentsView;
    }(View_1.View));
    exports.CommentsView = CommentsView;
});
