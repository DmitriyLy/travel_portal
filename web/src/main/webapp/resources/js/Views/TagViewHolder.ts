import {View} from "./View";

export class TagViewHolder extends View {

    constructor(params) {
        super('<button class="btn btn-default">$name$</button>', params);
    }
}