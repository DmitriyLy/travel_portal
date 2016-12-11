export class View {
    template : string;
    params : string[];

    constructor(template) {
        this.template = template;
    }

    /***
     * Renders template
     */
    render(params) {
        return replaceTemplateVars(this.template, params);
    }
}