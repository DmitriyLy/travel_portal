package com.netcracker.repositories.impl;

import com.netcracker.entities.SocialNetwork;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitriy Lysai
 */
@Repository
public class SocialNetworkRepositoryImpl implements IRepository<SocialNetwork> {
    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public SocialNetwork add(SocialNetwork item) {
        String query = QueriesRepository.INSERT_SOCIAL_NETWORK;
        int out = template.update(query,
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert social network");
        }

        return item;
    }

    @Override
    public SocialNetwork update(SocialNetwork item) {
        String query = QueriesRepository.UPDATE_SOCIAL_NETWORK;
        int out = template.update(query,
                item.getName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update social network");
        }

        return item;
    }

    @Override
    public SocialNetwork remove(SocialNetwork item) {
        String query = QueriesRepository.DELETE_SOCIAL_NETWORK;
        int out = template.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not delete social network");
        }

        return item;
    }

    @Override
    public SocialNetwork getById(long id) {
        String query = QueriesRepository.GET_SOCIAL_NETWORK_BY_ID;
        return template.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            SocialNetwork socialNetwork = new SocialNetwork();
            socialNetwork.setId(rs.getInt("id"));
            socialNetwork.setName(rs.getString("name"));
            return socialNetwork;
        });
    }

    @Override
    public List<SocialNetwork> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), (rs, rowNum) -> {
            SocialNetwork socialNetwork = new SocialNetwork();
            socialNetwork.setId(rs.getInt("id"));
            socialNetwork.setName(rs.getString("name"));
            return socialNetwork;
        });
    }
}
