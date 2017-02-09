var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var MarkerOverviewViewHolder = (function (_super) {
        __extends(MarkerOverviewViewHolder, _super);
        function MarkerOverviewViewHolder(params) {
            return _super.call(this, '<div class="marker-item col-xs-12" data-marker-id="$id$">' +
                '<div class="hoverable-item">' +
                '<div class="row">' +
                '<div class="owner col-xs-12 col-md-7 pull-left" data-owner-id="$owner_id$" title="$owner_name$">$owner_name$</div>' +
                '<div class="date col-xs-12 col-md-5 pull-right text-right"><button class="remove-marker $actions_visibility$ pull-right btn-danger btn hidden"><i class="fa fa-times" aria-hidden="true"></i></button>$creationDate$</div>' +
                '</div>' +
                '</div>' +
                '</div>', params) || this;
        }
        return MarkerOverviewViewHolder;
    }(View_1.View));
    exports.MarkerOverviewViewHolder = MarkerOverviewViewHolder;
});
