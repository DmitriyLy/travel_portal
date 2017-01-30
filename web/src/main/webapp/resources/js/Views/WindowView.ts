import {View} from "./View";
declare var heredoc:any;

export class WindowView extends View {

    constructor(params) {
        super('<div class="window">' +
                '<h2><div class="close-window-button"></div>$title$</h2>' +
                '<div class="content col-xs-12">$content$</div>' +
            '</div>',params);

    }

}