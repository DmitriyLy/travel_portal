import {View} from "./View";

export class CommentsView extends View {

    constructor(params) {
        super(
            '<div class="comments">' +
                '<div class="comments-list row">$comments$</div>' +
            '</div>',params);
    }
}