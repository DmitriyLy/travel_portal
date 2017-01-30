var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var TagViewHolder = (function (_super) {
        __extends(TagViewHolder, _super);
        function TagViewHolder(params) {
            return _super.call(this, '<button class="btn btn-default">$name$</button>', params) || this;
        }
        return TagViewHolder;
    }(View_1.View));
    exports.TagViewHolder = TagViewHolder;
});
