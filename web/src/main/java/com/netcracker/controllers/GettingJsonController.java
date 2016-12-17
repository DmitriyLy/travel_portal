package com.netcracker.controllers;

import com.netcracker.entities.FullLabelInfo;
import com.netcracker.services.impl.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dima_2 on 15.12.2016.
 */
@Controller
@RequestMapping("/json")
public class GettingJsonController {

    @Autowired
    LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public FullLabelInfo printJson(ModelMap model) {
        return labelService.getFullLabelInfo(1);
    }

}
