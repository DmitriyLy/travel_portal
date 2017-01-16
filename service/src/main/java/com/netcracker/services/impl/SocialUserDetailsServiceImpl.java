package com.netcracker.services.impl;

import com.netcracker.repositories.impl.UserDAO;
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
public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
        return userDAO.findById(userId);
    }

}