package com.netcracker.securityConfig;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by blaze159 on 13.01.17.
 */
@Component
public class MyUserAccountValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private MyUserAccountDAO myUserAccountDAO;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == MyUserAccountForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {

        MyUserAccountForm form = (MyUserAccountForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "User name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password is required");

        if (errors.hasErrors()) {
            return;
        }

        if (!emailValidator.isValid(form.getEmail())) {

            errors.rejectValue("email", "", "Email is not valid");
            return;
        }

        MyUserAccount userAccount = myUserAccountDAO.findByUserName(form.getUserName());
        if (userAccount != null) {
            if (form.getId() == null) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            } else if (!form.getId().equals(userAccount.getId())) {
                errors.rejectValue("userName", "", "User name is not available");
                return;
            }
        }

        userAccount = myUserAccountDAO.findByEmail(form.getEmail());
        if (userAccount != null) {
            if (form.getId() == null) {
                errors.rejectValue("email", "", "Email is not available");
                return;
            } else if (!form.getId().equals(userAccount.getId())) {
                errors.rejectValue("email", "", "Email is not available");
                return;
            }
        }
    }

}
