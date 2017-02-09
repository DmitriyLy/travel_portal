import {View} from "./View";

export class MarkerOverviewViewHolder extends View {

    constructor(params) {
        super(
            '<div class="marker-item col-xs-12" data-marker-id="$id$">' +
                '<div class="hoverable-item">' +
                    '<div class="row">' +
                        '<div class="owner col-xs-12 col-md-7 pull-left" data-owner-id="$owner_id$" title="$owner_name$">$owner_name$</div>' +
                        '<div class="date col-xs-12 col-md-5 pull-right text-right"><button class="remove-marker $actions_visibility$ pull-right btn-danger btn hidden"><i class="fa fa-times" aria-hidden="true"></i></button>$creationDate$</div>' +
                    '</div>' +
                '</div>' +
            '</div>',params);
    }
}