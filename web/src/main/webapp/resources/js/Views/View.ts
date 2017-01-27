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
        return replaceTemplateVars(this.template, this.params);
    }
}