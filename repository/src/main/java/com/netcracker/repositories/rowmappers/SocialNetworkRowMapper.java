package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.SocialNetwork;
import com.netcracker.repositories.impl.SocialNetworkRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class SocialNetworkRowMapper implements RowMapper<SocialNetwork> {

    @Override
    public SocialNetwork mapRow(ResultSet rs, int rowNum) throws SQLException {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setId(rs.getInt("id"));
        socialNetwork.setName(rs.getString("name"));
        return socialNetwork;
    }
}
