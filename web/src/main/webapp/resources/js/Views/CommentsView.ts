import {View} from "./View";

export class CommentsView extends View {

    constructor(params) {
        super(
            '<div class="comments" data-label-id="$marker_id$">' +
                '<div class="comments-form row">$form$</div>' +
                '<div class="comments-list row">$comments$</div>' +
            '</div>',params);
    }
}