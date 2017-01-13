package com.netcracker.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by blaze159 on 13.01.17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Set Service load Users in Database
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/signup", "/login", "/logout").permitAll();

        // /userInfo page requires login as ROLE_USER
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo").access("hasRole('ROLE_USER')");

        // Form Login config
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password");

        // Logout Config
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

        // Spring Social Config.
        http.apply(new SpringSocialConfigurer())
                //
                .signupUrl("/signup");

    }


    // This bean is load the user specific data when form login is used.
    @Override
    public UserDetailsService userDetailsService() {
        return myUserDetailsService;
    }

}
