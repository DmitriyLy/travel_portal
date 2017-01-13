package com.netcracker.securityConfig;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by blaze159 on 13.01.17.
 */
public class MyUserAccountMapper implements RowMapper<MyUserAccount> {

    @Override
    public MyUserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {

        String id = rs.getString("id");

        String email = rs.getString("email");
        String userName= rs.getString("user_name");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String password = rs.getString("password");
        String role = rs.getString("role");

        return new MyUserAccount(id, email,userName, firstName, //
                lastName, password, //
                role );
    }

}
