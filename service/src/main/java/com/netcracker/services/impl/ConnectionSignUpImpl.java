package com.netcracker.services.impl;

import com.netcracker.entities.User;
import com.netcracker.repositories.impl.UserDAO;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

/**
 * Created by blaze159 on 13.01.17.
 */
@Service
public class ConnectionSignUpImpl implements ConnectionSignUp {

    private UserDAO userDAO;

    public ConnectionSignUpImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String execute(Connection<?> connection) {
        User account = userDAO.createUserAccount(connection);
        return account.getId();
    }
}
