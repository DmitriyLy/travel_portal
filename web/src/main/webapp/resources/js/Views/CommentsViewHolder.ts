import {View} from "./View";

export class CommentsViewHolder extends View {

    constructor(params) {
        super(
            '<div class="comment col-xs-12" data-comment-id="$id$">' +
                '<div class="row">' +
                    '<div class="owner col-xs-12 col-md-7 pull-left" data-owner-id="$owner_id$" title="$owner_name$">$owner_name$</div>' +
                    '<div class="date col-xs-12 col-md-5 pull-right text-right"><button data-marker-id="$marker_id$" data-comment-id="$id$" class="btn btn-danger remove-comment $actions_visibility$ pull-right"><i class="fa fa-times" aria-hidden="true"></i></button>$creationDate$</div>' +
                '</div>' +
                '<div class="row">' +
                    '<div class="col-xs-12 comment-text">$text$</div>' +
                '</div>' +
            '</div>', params);
    }
}