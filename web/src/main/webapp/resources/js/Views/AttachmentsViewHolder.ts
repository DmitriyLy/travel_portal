import {View} from "./View";

export class AttachmentsViewHolder extends View {

    constructor(params) {
        super('<a href="/resources/uploaded-images/$full$" class="col-xs-3" data-id="$id$"><img class="img-responsive" src="/resources/uploaded-images/$thumb$"/></a>', params);
    }
}