package com.netcracker.repositories.impl;

import com.netcracker.entities.MapProvider;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.MapProviderRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima_2 on 30.11.2016.
 */
@Repository
public class MapProviderRepositoryImpl implements IRepository<MapProvider> {

    private final static Logger LOGGER = LogManager.getLogger(MapProviderRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private MapProviderRowMapper providerRowMapper;

    @Override
    public void add(MapProvider item) {
        String query = IQueriesRepository.INSERT_MAP_PROVIDER;
        int out = template.update(query, new Object[]{item.getName(), item.getCoordSysName()});
        if(out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }
    }

    @Override
    public void update(MapProvider item) {
        String query = IQueriesRepository.UPDATE_MAP_PROVIDER;
        int out = template.update(query, new Object[]{item.getName(), item.getCoordSysName(), item.getId()});
        if(out == 0) {
            LOGGER.warn("Cannot update " + item.toString());
        }
    }

    @Override
    public void remove(MapProvider item) {
        String query = IQueriesRepository.DELETE_MAP_PROVIDER;
        int out = template.update(query, new Object[]{item.getId()});
        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }
    }

    @Override
    public MapProvider getById(long id) {
        String query = IQueriesRepository.GET_MAP_PROVIDER_BY_ID;
        return template.queryForObject(query,new Object[] {id}, providerRowMapper);
    }

    @Override
    public List<MapProvider> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), providerRowMapper);
    }
}
