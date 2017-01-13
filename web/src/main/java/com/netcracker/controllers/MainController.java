package com.netcracker.controllers;

import com.netcracker.securityConfig.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by blaze159 on 13.01.17.
 */
@Controller
public class MainController {

    @Autowired
    private MyUserAccountDAO myUserAccountDAO;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    private UsersConnectionRepository connectionRepository;

    @Autowired
    private MyUserAccountValidator myUserAccountValidator;

    // Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == MyUserAccountForm.class) {
            dataBinder.setValidator(myUserAccountValidator);
        }
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            if (userDetails != null) {
                System.out.println(userDetails.getPassword());
                System.out.println(userDetails.getUsername());
                System.out.println(userDetails.isEnabled());

                model.addAttribute("userDetails", userDetails);
            }
        } catch (Exception e) {
        }
        return "index2";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        return "login";
    }

    // User login via Social,
    // but not allow access basic info.
    // webapp will redirect to /signin.
    @RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
    public String signInPage(Model model) {
        return "redirect:/login";
    }

    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public String signupPage(WebRequest request, Model model) {

        ProviderSignInUtils providerSignInUtils //
                = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);


        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);

        //
        MyUserAccountForm myForm = null;
        //
        if (connection != null) {
            myForm = new MyUserAccountForm(connection);
        } else {
            myForm = new MyUserAccountForm();
        }
        model.addAttribute("myForm", myForm);
        return "signup";
    }

    @RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
    public String signupSave(WebRequest request, //
                             Model model, //
                             @ModelAttribute("myForm") @Validated MyUserAccountForm accountForm, //
                             BindingResult result, //
                             final RedirectAttributes redirectAttributes) {

        // If validation has error.
        if (result.hasErrors()) {
            return "signup";
        }

        MyUserAccount registered = null;

        try {
            registered = myUserAccountDAO.registerNewUserAccount(accountForm);
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("errorMessage", "Error " + ex.getMessage());
            return "signup";
        }

        if (accountForm.getSignInProvider() != null) {
            ProviderSignInUtils providerSignInUtils //
                    = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);

            // If the user is signing in by using a social provider, this method
            // call stores the connection to the UserConnection table.
            // Otherwise, this method does not do anything.
            providerSignInUtils.doPostSignUp(registered.getId(), request);
        }
        // After register, Logs the user in.
        SecurityUtil.logInUser(registered);

        return "redirect:/userInfo";
    }

    @RequestMapping(value = { "/userInfo" }, method = RequestMethod.GET)
    public String userInfoPage(WebRequest request, Model model) {
        return "userInfo";
    }

}
