package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setSocNetUserId(rs.getString("soc_net_user_id"));
        user.setSocialNetworkId(rs.getLong("soc_net_id"));
        user.setStatus(rs.getInt("status"));
        return user;

    }
}
