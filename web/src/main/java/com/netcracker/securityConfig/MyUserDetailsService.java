package com.netcracker.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by blaze159 on 13.01.17.
 */
// Service to Get user info from Database.
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserAccountDAO myUserAccountDAO;

    public MyUserDetailsService() {

    }

    // (This method is used by Spring Security API).
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        MyUserAccount myUserAccount = myUserAccountDAO.findByUserName(userName);

        if (myUserAccount == null) {
            throw new UsernameNotFoundException("No user found with userName: " + userName);
        }
        // Note: SocialUserDetails extends UserDetails.
        SocialUserDetails principal = new MySocialUserDetails(myUserAccount);

        return principal;
    }

}
