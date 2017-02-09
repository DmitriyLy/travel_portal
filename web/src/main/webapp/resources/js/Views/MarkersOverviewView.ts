import {View} from "./View";

export class MarkersOverviewView extends View {

    constructor(params) {
        super(
            '<div class="marker">' +
                '<div class="marker-list $additional_class$ row">$markers$</div>' +
            '</div>', params);
    }
}