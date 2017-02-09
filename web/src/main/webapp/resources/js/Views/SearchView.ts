import {View} from "./View";
declare var heredoc:any;

export class SearchView extends View {

    constructor(params) {
        super(
            '<div class="search">' +
                '<ul class="nav nav-tabs nav-justified">' +
                    '<li class="active"><a data-toggle="tab" href="#regular_search">По адресу</a></li>' +
                    '<li><a data-toggle="tab" href="#advanced_search">Расширеный</a></li>' +
                    '<li><a data-toggle="tab" href="#tags_search">По тегам</a></li>' +
                '</ul>' +
                '<div class="tab-content">' +
                    '<div id="regular_search" class="tab-pane fade in active">' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Адрес:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="address col-xs-12">' +
                                '<input type="text" value="" />' +
                            '</div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><button class="btn btn-default pull-right" id="regular-marker-search">Поиск</button></div>' +
                        '</div>' +
                    '</div>' +
                    '<div id="advanced_search" class="tab-pane fade">' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Адрес:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="address col-xs-12">' +
                                '<input type="text" value="" />' +
                            '</div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Рейтинг:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="rating col-xs-12">' +
                                '<label><input type="checkbox" name="rating" value="0"/> 0</label> ' +
                                '<label><input type="checkbox" name="rating" value="1"/> 1</label> ' +
                                '<label><input type="checkbox" name="rating" value="2"/> 2</label> ' +
                                '<label><input type="checkbox" name="rating" value="3"/> 3</label> ' +
                                '<label><input type="checkbox" name="rating" value="4"/> 4</label> ' +
                                '<label><input type="checkbox" name="rating" value="5"/> 5</label> ' +
                            '</div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Категории:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="categories col-xs-12">' +
                                '<select id="categories-container" multiple>$available_categories$</select>' +
                            '</div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Теги:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="tags col-xs-12">' +
                                '<input type="text" value="" /><em id="review-info" class="info help-block">Теги разделяются запятыми.</em>' +
                            '</div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><button class="btn btn-default pull-right" id="advanced-marker-search">Поиск</button></div>' +
                        '</div>' +
                    '</div>' +
                    '<div id="tags_search" class="tab-pane fade">' +
                        '<div class="row">' +
                            '<div class="col-xs-12"><h4>Теги:</h4></div>'+
                        '</div>' +
                        '<div class="row">' +
                            '<div class="tags col-xs-12">$available_tags$</div>'+
                        '</div>' +
                    '</div>' +
                '</div>' +
            '</div>',params);
    }
}