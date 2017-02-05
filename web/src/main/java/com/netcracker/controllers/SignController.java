package com.netcracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by blaze159 on 05.02.17.
 */
@Controller
public class SignController {

    @RequestMapping(value = { "/signFacebook" }, method = RequestMethod.GET)
    public String signFacebook(@RequestParam("fallback_url") String fallback, HttpSession session) {
        session.setAttribute("fallback_url",fallback);
        return "redirect:/auth/facebook";
    }

    @RequestMapping(value = { "/signGoogle" }, method = RequestMethod.GET)
    public String signGoogle(@RequestParam("fallback_url") String fallback, HttpSession session) {
        session.setAttribute("fallback_url",fallback);
        return "redirect:/auth/google";
    }

    @RequestMapping(value = { "/postSignIn" }, method = RequestMethod.GET)
    public String postSignIn(HttpSession session) {
        String sesParam = (String)session.getAttribute("fallback_url");
        return "redirect:/#"+sesParam;
    }
}
