import {View} from "./View";
declare var heredoc:any;

export class CreateMarkerView extends View {
    constructor(params) {
        super(
            '<div class="marker">' +
                '<div class="row">' +
                    '<div class="owner col-xs-12 col-md-7 pull-left" title="$owner_name$">Вы</div>' +
                    '<div class="date col-xs-12 col-md-5 pull-right text-right">Сейчас</div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="address col-xs-12"><select>$address$</select></div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="rating col-xs-12">Рейтинг: <span class="rate">' +
                        '<label><input type="checkbox" name="rating" value="0" checked/> 0</label> ' +
                        '<label><input type="checkbox" name="rating" value="1"/> 1</label> ' +
                        '<label><input type="checkbox" name="rating" value="2"/> 2</label> ' +
                        '<label><input type="checkbox" name="rating" value="3"/> 3</label> ' +
                        '<label><input type="checkbox" name="rating" value="4"/> 4</label> ' +
                        '<label><input type="checkbox" name="rating" value="5"/> 5</label> ' +
                    '</span></div>'+
                '</div>' +
                '<div class="row">' +
                    '<div class="review col-xs-12"><textarea></textarea></div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="col-xs-12"><div class="row"><div class="col-xs-12">Категории:</div></div></div>' +
                    '<div class="categories col-xs-12"><div class="row"><div class="col-xs-12"><input type="text" /></div></div></div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="col-xs-12"><div class="row"><div class="col-xs-12">Теги:</div></div></div>' +
                    '<div class="tags col-xs-12"><div class="row"><div class="col-xs-12"><input type="text" /></div></div></div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="col-xs-12"><div class="row"><div class="col-xs-12">Изображения:</div></div></div>' +
                    '<div class="attachments col-xs-12"><div class="row text-center attachment-container"><div class="col-xs-3"><div id="add-attachment"><i class="fa fa-plus fa-2" aria-hidden="true"></i></div></div></div></div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="col-xs-12"><button class="btn btn-default pull-right" id="insert-marker">Сохранить Метку</button></div>' +
                '</div>' +
            '</div>',params);
    }
}