package com.netcracker.securityConfig;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * Created by blaze159 on 13.01.17.
 */
public class MyConnectionSignUp implements ConnectionSignUp {

    private MyUserAccountDAO myUserAccountDAO;

    public MyConnectionSignUp(MyUserAccountDAO myUserAccountDAO) {
        this.myUserAccountDAO = myUserAccountDAO;
    }

    @Override
    public String execute(Connection<?> connection) {
        MyUserAccount account = myUserAccountDAO.createUserAccount(connection);
        return account.getId();
    }
}
