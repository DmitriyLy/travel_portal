package com.netcracker.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by blaze159 on 13.01.17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.headers().frameOptions().disable();

        http.authorizeRequests().antMatchers("/", "/logout").permitAll();

       /* http.authorizeRequests().antMatchers("/labels*//**", "/users*//**", "/postSignIn",
                "/tags", "/categories")
                .access("hasRole('ROLE_USER')");*/


        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.apply(new SpringSocialConfigurer().postLoginUrl("/postSignIn"));

    }
}
