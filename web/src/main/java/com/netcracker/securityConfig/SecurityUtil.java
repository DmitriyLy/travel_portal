package com.netcracker.securityConfig;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by blaze159 on 13.01.17.
 */
public class SecurityUtil {

    // Auto login.
    public static void logInUser(MyUserAccount user) {

        MySocialUserDetails userDetails = new MySocialUserDetails(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}