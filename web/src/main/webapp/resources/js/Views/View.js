define(["require", "exports", "../Helpers/ReplaceTemplateVars"], function (require, exports, ReplaceTemplateVars_1) {
    "use strict";
    var View = (function () {
        function View(template, params) {
            this.template = template;
            this.params = params;
        }
        /***
         * Renders template
         */
        View.prototype.render = function () {
            return ReplaceTemplateVars_1.StringHelper.replaceTemplateVars(this.template, this.params);
        };
        return View;
    }());
    exports.View = View;
});
