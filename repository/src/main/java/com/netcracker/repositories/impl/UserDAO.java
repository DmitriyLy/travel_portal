package com.netcracker.repositories.impl;


import com.netcracker.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created by blaze159 on 13.01.17.
 */
@Repository
@Transactional
public class UserDAO extends JdbcDaoSupport {

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    private final RowMapper<User> mapper = (rs, rowNum) -> {
        String id = rs.getString("id");

        String email = rs.getString("email");
        String userName = rs.getString("user_name");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String role = rs.getString("role");

        return new User(id, email, userName,
                firstName, lastName, role);
    };

    public User findById(String id) {
        String sql = "Select id,email,user_name, first_name,last_name,"
                + " role"
                + " from USERS u "
                + " where id = ? ";
        Object[] params = new Object[]{id};
        try {
            User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findByEmail(String email) {
        String sql = "Select id, email,user_name,first_name,last_name,"
                + " role"
                + " from USERS u "
                + " where email = ? ";
        Object[] params = new Object[]{email};
        try {
            User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findByUserName(String userName) {
        String sql = "Select id, email,user_name,first_name,last_name,"
                + " role"
                + " from USERS u "
                + " where user_name = ? ";
        Object[] params = new Object[]{userName};
        try {
            User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User createUserAccount(Connection<?> connection) {

        UserProfile userProfile = connection.fetchUserProfile();

        User account = this.findById(userProfile.getId());
        if (account != null) {
            return account;
        }

        String sql = "Insert into USERS "
                + " (id, email,user_name,first_name,last_name,role) "
                + " values (?,?,?,?,?,?) ";

        // Random string with 36 characters.
        String id = UUID.randomUUID().toString();

        String userName = userProfile.getFirstName().trim()
                + " " + userProfile.getLastName().trim();

        this.getJdbcTemplate().update(sql, id, userProfile.getEmail(), userName,
                userProfile.getFirstName(), userProfile.getLastName(), User.ROLE_USER);
        return findById(id);
    }
}