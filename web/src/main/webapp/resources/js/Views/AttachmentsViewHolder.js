var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var AttachmentsViewHolder = (function (_super) {
        __extends(AttachmentsViewHolder, _super);
        function AttachmentsViewHolder(params) {
            return _super.call(this, '<a href="/resources/uploaded-images/$full$" class="col-xs-3" data-id="$id$"><img class="img-responsive" src="/resources/uploaded-images/$thumb$"/></a>', params) || this;
        }
        return AttachmentsViewHolder;
    }(View_1.View));
    exports.AttachmentsViewHolder = AttachmentsViewHolder;
});
