import {View} from "../Views/View";

export class StringHelper {
    static replaceTemplateVars(content, vars) {
        return content.replace(/\$(\w+)\$/gm, ($0, $1)=> {
            return ($1 in vars ? (vars[$1] instanceof View ? vars[$1].render() : vars[$1]) : $0);
        });
    }
}