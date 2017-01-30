import {View} from "./View";

export class CommentsFormView extends View {

    constructor(params) {
        super('<div class="col-xs-12 text-left">Оставьте коментарий:</div>' +
            '<div class="col-xs-12 text-center"><textarea id="comment-area"></textarea></div>' +
            '<div class="col-xs-12 text-right"><button class="btn btn-default" id="send-comment" data-marker-id="$marker_id$">Написать</button></div>', params);
    }
}