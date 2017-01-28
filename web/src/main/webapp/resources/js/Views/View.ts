import {StringHelper} from "../Helpers/ReplaceTemplateVars";
export class View {
    template : string;
    params : Object;

    constructor(template,params) {
        this.template = template;
        this.params = params;
    }

    /***
     * Renders template
     */
    render() {
        return StringHelper.replaceTemplateVars(this.template, this.params);
    }
}