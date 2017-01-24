package com.netcracker.controllers;

import com.netcracker.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by blaze159 on 13.01.17.
 */
@Controller
public class MainController {

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        try {
            User user = (User)SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            if (user != null) {
                System.out.println(user.getLastName());
                System.out.println(user.isEnabled());
                        model.addAttribute("userDetails", user);
            }
        } catch (Exception e) {
        }
        return "index2";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        return "login";
    }

    @RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
    public String signInPage(Model model) {
        return "redirect:/login";
    }

    @RequestMapping(value = { "/userInfo" }, method = RequestMethod.GET)
    public String userInfoPage(WebRequest request, Model model) {
        return "userInfo";
    }

}
