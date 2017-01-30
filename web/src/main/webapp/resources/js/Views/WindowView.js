var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var WindowView = (function (_super) {
        __extends(WindowView, _super);
        function WindowView(params) {
            return _super.call(this, '<div class="window">' +
                '<h2><div class="close-window-button"></div>$title$</h2>' +
                '<div class="content col-xs-12">$content$</div>' +
                '</div>', params) || this;
        }
        return WindowView;
    }(View_1.View));
    exports.WindowView = WindowView;
});
