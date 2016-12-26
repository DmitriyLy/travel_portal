package com.netcracker.repositories.impl;

import com.netcracker.entities.Location;
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

@Repository
public class LocationRepositoryImpl implements IRepository<Location> {

    private final static Logger LOGGER = LogManager.getLogger(LocationRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Location> mapper = (rs, rowNum) -> {
        Location location = new Location();
        location.setId(rs.getLong("id"));
        location.setCityId(rs.getLong("city_id"));
        location.setStreet(rs.getString("street"));
        location.setBuilding(rs.getString("building"));
        return location;
    };

    @Override
    public Location add(Location item) {
        String query = QueriesRepository.INSERT_LOCATION;
        //item.setId(getLastRowId());
        item.setId(getNewLocationId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getCityId(),
                item.getStreet(),
                item.getBuilding()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert Location = " + item.toString());
        }

        return item;
    }

    @Override
    public Location update(Location item) {
        String query = QueriesRepository.UPDATE_LOCATION;
        int out = jdbcTemplate.update(query,
                item.getCityId(),
                item.getStreet(),
                item.getBuilding(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update Location = " + item.toString());
        }

        return item;
    }

    @Override
    public Location remove(Location item) {
        String query = QueriesRepository.DELETE_LOCATION;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not remove Location = " + item.toString());
        }

        return item;
    }

    @Override
    public Location getById(long id) {
        String query = QueriesRepository.GET_LOCATION_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_LOCATIONS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Location> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in LOCATIONS table.
     */
    private long getNewLocationId(){
        String query = QueriesRepository.GET_NEW_ID_LOCATIONS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
