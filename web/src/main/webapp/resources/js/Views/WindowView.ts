import {View} from "./View";
declare var heredoc:any;

export class WindowView extends View {

    constructor() {
        super('<div class="window">' +
                '<h2>$title$</h2>' +
                '<div class="content">$content$</div>' +
            '</div>');

    }

}