package com.netcracker.securityConfig;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * Created by blaze159 on 13.01.17.
 */
public class MyConnectionSignUp implements ConnectionSignUp {

    private UserDAO userDAO;

    public MyConnectionSignUp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String execute(Connection<?> connection) {
        User account = userDAO.createUserAccount(connection);
        return account.getId();
    }
}
