package com.netcracker.repositories.impl;

import com.netcracker.entities.User;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Egor Oveian
 */
@Repository
public class UserRepositoryImpl implements IRepository<User> {

    private final static Logger LOGGER = LogManager.getLogger(UserRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> mapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setSocNetUserId(rs.getString("soc_net_user_id"));
        user.setSocialNetworkId(rs.getLong("soc_net_id"));
        user.setStatus(rs.getInt("status"));
        return user;
    };

    @Override
    public User add(User item) {
        String query = QueriesRepository.INSERT_USER;
        //item.setId(getLastRowId() +1);
        item.setId(getNewUserId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getFirstName(),
                item.getLastName(),
                item.getSocNetUserId(),
                item.getSocialNetworkId(),
                item.getStatus()
        );

        if (out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public User update(User item) {
        String query = QueriesRepository.UPDATE_USER;
        int out = jdbcTemplate.update(query,
                item.getFirstName(),
                item.getLastName(),
                item.getSocNetUserId(),
                item.getSocialNetworkId(),
                item.getStatus(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public User remove(User item) {
        String query = QueriesRepository.DELETE_USER;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public User getById(long id) {
        String query = QueriesRepository.GET_USER_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_USERS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<User> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in USERS table.
     */
    private long getNewUserId(){
        String query = QueriesRepository.GET_NEW_ID_USERS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
