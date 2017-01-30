var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var CommentsRegisterFormView = (function (_super) {
        __extends(CommentsRegisterFormView, _super);
        function CommentsRegisterFormView(params) {
            return _super.call(this, '<div class="col-xs-12 text-center"><b>чтобы оставлять комментарии<br>вы должны войти:</b></div>' +
                '<div class="col-xs-6 text-center"><a href="$facebook_url$"><i class="fa fa-facebook-square fa-3x" aria-hidden="true"></i></a></div>' +
                '<div class="col-xs-6 text-center"><a href="$google_url$"><i class="fa fa-google-plus fa-3x" aria-hidden="true"></i></a></div>', params) || this;
        }
        return CommentsRegisterFormView;
    }(View_1.View));
    exports.CommentsRegisterFormView = CommentsRegisterFormView;
});
