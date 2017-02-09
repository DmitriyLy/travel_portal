import {View} from "./View";

export class CommentsFormView extends View {

    constructor(params) {
        super('<div class="col-xs-12">Оставьте коментарий:</div>' +
            '<div class="col-xs-12"><form id="CommentsForm"><textarea id="comment-area" name="comment-area"></textarea></form></div>' +
            '<div class="col-xs-12 text-right"><button class="btn btn-default" id="send-comment" data-marker-id="$marker_id$">Написать</button></div>', params);
    }
}