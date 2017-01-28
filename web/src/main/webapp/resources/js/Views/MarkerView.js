var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var MarkerView = (function (_super) {
        __extends(MarkerView, _super);
        function MarkerView(params) {
            _super.call(this, '<div class="marker">' +
                '<div class="row">' +
                '<div class="owner col-xs-12 col-md-7 pull-left" data-owner-id="$owner_id$" title="$owner_name$">$owner_name$</div>' +
                '<div class="date col-xs-12 col-md-5 pull-right text-right">$creationDate$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="address col-xs-12">$address$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="rating col-xs-12">Рейтинг: <span class="rate-$rating$"></span></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="review col-xs-12">$review$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="categories col-xs-12">Категории: $categories$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="tags col-xs-12">Теги: $tags$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="attachments col-xs-12">Изображения:<div class="row text-center">$attachments$</div></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12 text-center"><script src="//yastatic.net/es5-shims/0.0.2/es5-shims.min.js"></script><script src="//yastatic.net/share2/share.js"></script><div class="ya-share2" data-services="vkontakte,facebook,gplus,twitter,linkedin" data-counter="" data-url="http://nctravelportal.ddns.net/#marker-$marker_id$" data-title="Метка пользователя $owner_name$, на карте NetCrackerMap." data-image="http://nctravelportal.ddns.net/resources/images/logo.png"></div></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12 text-center"><button data-marker-id="$marker_id$" class="btn btn-default open-comments-button">Коментарии: $commentCount$ <i class="fa fa-commenting" aria-hidden="true"></i></button></div>' +
                '</div>' +
                '</div>', params);
        }
        return MarkerView;
    }(View_1.View));
    exports.MarkerView = MarkerView;
});
