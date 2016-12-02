package com.netcracker.repositories.impl;

import com.netcracker.entities.Location;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.LocationRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements IRepository<Location> {

    private final static Logger LOGGER = LogManager.getLogger(LocationRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private LocationRowMapper locationRowMapper;

    @Override
    public void add(Location item) {
        String query = IQueriesRepository.INSERT_LOCATION;
        int out = template.update(query, new Object[]{item.getCity().getId(), item.getStreet(), item.getBuilding()});
        if(out == 0) {
            LOGGER.warn("Could not insert Location = " + item.toString());
        }
    }

    @Override
    public void update(Location item) {
        String query = IQueriesRepository.UPDATE_LOCATION;
        int out = template.update(query, new Object[]{item.getCity().getId(), item.getStreet(), item.getBuilding(),
                                                        item.getId()});
        if(out == 0) {
            LOGGER.warn("Could not update Location = " + item.toString());
        }
    }

    @Override
    public void remove(Location item) {
        String query = IQueriesRepository.DELETE_LOCATION;
        int out = template.update(query, item.getId());
        if(out == 0) {
            LOGGER.warn("Could not remove Location = " + item.toString());
        }
    }

    @Override
    public Location getById(long id) {
        String query = IQueriesRepository.GET_LOCATION_BY_ID;
        return template.queryForObject(query,new Object[] {id}, locationRowMapper);
    }

    @Override
    public List<Location> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), locationRowMapper);
    }
}
