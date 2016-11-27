package com.netcracker.controllers;

import com.netcracker.services.impl.BasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for {@link com.netcracker.entities.BasicEntity}' s pages.
 *
 * @author Oveian Egor
 */

@Controller
public class BasicController {

    @Autowired
    BasicServiceImpl basicService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView basicMethod(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", basicService.basicMethod());
        modelAndView.setViewName("basicView");
        return modelAndView;
    }
}
