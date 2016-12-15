package com.netcracker.controllers;

import com.netcracker.services.impl.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

/**
 * Created by dima_2 on 15.12.2016.
 */
@Controller
@RequestMapping("/json")
public class GettingJsonController {

    @Autowired
    LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public String printJson(ModelMap model) {
        model.addAttribute("json_text", labelService.getFullLabelInfoJson(1));
        return "json";
    }

}
