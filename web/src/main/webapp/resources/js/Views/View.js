define(["require", "exports"], function (require, exports) {
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
            return replaceTemplateVars(this.template, this.params);
        };
        return View;
    }());
    exports.View = View;
});
