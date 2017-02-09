var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", "./View"], function (require, exports, View_1) {
    "use strict";
    var CreateMarkerView = (function (_super) {
        __extends(CreateMarkerView, _super);
        function CreateMarkerView(params) {
            return _super.call(this, '<div class="marker">' +
                '<form id="CreateMarker">' +
                '<input type="hidden" name="marker_id" value="$marker_id$">' +
                '<input type="hidden" name="latitude" value="$latitude$">' +
                '<input type="hidden" name="longitude" value="$longitude$">' +
                '<input type="hidden" name="op_type" value="$op_type$">' +
                '<div class="row">' +
                '<div class="owner col-xs-12 col-md-7 pull-left" title="$owner_name$">$owner_name$</div>' +
                '<div class="date col-xs-12 col-md-5 pull-right text-right">$creation_date$</div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Адрес:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="address col-xs-12"><select>$address$</select></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Рейтинг:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="rating col-xs-12"><span class="rate">' +
                '<label><input type="checkbox" name="rating" value="0"/> 0</label> ' +
                '<label><input type="checkbox" name="rating" value="1"/> 1</label> ' +
                '<label><input type="checkbox" name="rating" value="2"/> 2</label> ' +
                '<label><input type="checkbox" name="rating" value="3"/> 3</label> ' +
                '<label><input type="checkbox" name="rating" value="4"/> 4</label> ' +
                '<label><input type="checkbox" name="rating" value="5"/> 5</label> ' +
                '</span></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Ревью:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="review col-xs-12"><textarea name="review">$review$</textarea></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Категории:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="categories col-xs-12"><select id="categories-container" multiple>$available_categories$</select><input type="hidden" name="categories" value="$selected_categories$" /></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Теги:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="tags col-xs-12"><input type="text" name="tags" value="$selected_tags$"/><em id="review-info" class="info help-block">Теги разделяются запятыми.</em></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="col-xs-12"><h4>Изображения:</h4></div>' +
                '</div>' +
                '<div class="row">' +
                '<div class="attachments col-xs-12"><div class="row text-center attachment-container"><div class="col-xs-3"><div id="add-attachment"><i class="fa fa-plus fa-2" aria-hidden="true"></i><input type="file" name="attach" id="attachment-file-input"></div></div></div>$attachment_notice$</div>' +
                '</div>' +
                '</form>' +
                '<div class="row">' +
                '<div class="col-xs-12"><button class="btn btn-default pull-right" id="insert-marker">Сохранить Метку</button></div>' +
                '</div>' +
                '</div>', params) || this;
        }
        return CreateMarkerView;
    }(View_1.View));
    exports.CreateMarkerView = CreateMarkerView;
});
