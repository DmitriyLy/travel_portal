package com.netcracker.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by blaze159 on 13.01.17.
 */
@Service
public class MySocialUserDetailsService implements SocialUserDetailsService {

    @Autowired
    private MyUserAccountDAO myUserAccountDAO;

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {

        MyUserAccount account= myUserAccountDAO.findById(userId);

        MySocialUserDetails userDetails= new MySocialUserDetails(account);

        return userDetails;
    }

}