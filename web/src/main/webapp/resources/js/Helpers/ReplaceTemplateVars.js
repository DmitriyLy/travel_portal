function replaceTemplateVars(content, vars) {
    return content.replace(/\$(\w+)\$/gm, function ($0, $1) {
        return ($1 in vars ? vars[$1] : $0);
    });
}
