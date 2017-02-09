var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var MarkersOverviewView = (function (_super) {
        __extends(MarkersOverviewView, _super);
        function MarkersOverviewView(params) {
            return _super.call(this, '<div class="marker">' +
                '<div class="marker-list $additional_class$ row">$markers$</div>' +
                '</div>', params) || this;
        }
        return MarkersOverviewView;
    }(View_1.View));
    exports.MarkersOverviewView = MarkersOverviewView;
});
