package com.netcracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String basicMethod(){
        return "index";
    }
}
