package com.netcracker.controllers;

import com.netcracker.entities.FullLabelInfo;
import com.netcracker.services.impl.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dima_2 on 15.12.2016.
 *
 * This controller is implemented to test Tomcat settings and to check JSON.
 * It is assumed to delete this controller in future.
 *
 */
@Controller
public class GettingJsonController {

    @Autowired
    LabelService labelService;

    @RequestMapping(value = "/json1", method = RequestMethod.GET)
    @ResponseBody
    public FullLabelInfo printJson() {
        return labelService.getFullLabelInfo(1);
    }

    @RequestMapping(value = "/json2", method = RequestMethod.GET)
    public String insertJsonIntoJsp(ModelMap model) {
        model.addAttribute("json_text", labelService.getFullLabelInfoJson(1));
        return "json";
    }

    @RequestMapping(value = "/json3", method = RequestMethod.GET)
    public String showJsonInputForm() {
        return "json_input_form";
    }

    @RequestMapping(value = "/json4", method = RequestMethod.POST)
    public String handleRetrievedJsonText(HttpServletRequest request, ModelMap model) {
        String retrievedJson = request.getParameter("json_text");

        FullLabelInfo fullLabelInfo = labelService.getFullLabelInfoFromJson(retrievedJson);
        if (fullLabelInfo != null) {
            model.addAttribute("json_text", labelService.getFullLabelInfoJson(fullLabelInfo.getId()));
        }
        return "result";
    }

}
