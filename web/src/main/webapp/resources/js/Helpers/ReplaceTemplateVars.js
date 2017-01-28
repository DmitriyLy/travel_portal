define(["require", "exports", "../Views/View"], function (require, exports, View_1) {
    "use strict";
    var StringHelper = (function () {
        function StringHelper() {
        }
        StringHelper.replaceTemplateVars = function (content, vars) {
            return content.replace(/\$(\w+)\$/gm, function ($0, $1) {
                return ($1 in vars ? (vars[$1] instanceof View_1.View ? vars[$1].render() : vars[$1]) : $0);
            });
        };
        return StringHelper;
    }());
    exports.StringHelper = StringHelper;
});
