define(["require", "exports"], function (require, exports) {
    "use strict";
    var View = (function () {
        function View(template) {
            this.template = template;
        }
        /***
         * Renders template
         */
        View.prototype.render = function (params) {
            return replaceTemplateVars(this.template, params);
        };
        return View;
    }());
    exports.View = View;
});
