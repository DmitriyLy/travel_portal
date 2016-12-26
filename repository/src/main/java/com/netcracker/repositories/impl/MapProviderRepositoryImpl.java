package com.netcracker.repositories.impl;

import com.netcracker.entities.MapProvider;
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
 * @author Dmitriy Lysai
 */
@Repository
public class MapProviderRepositoryImpl implements IRepository<MapProvider> {

    private final static Logger LOGGER = LogManager.getLogger(MapProviderRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<MapProvider> mapper = (rs, rowNum) -> {
        MapProvider mapProvider = new MapProvider();
        mapProvider.setId(rs.getInt("id"));
        mapProvider.setName(rs.getString("name"));
        mapProvider.setCoordSysName(rs.getString("coord_sys_name"));
        return mapProvider;
    };

    @Override
    public MapProvider add(MapProvider item) {
        String query = QueriesRepository.INSERT_MAP_PROVIDER;
        //item.setId(getLastRowId());
        item.setId(getNewMapProviderId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getName(),
                item.getCoordSysName()
        );

        if (out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public MapProvider update(MapProvider item) {
        String query = QueriesRepository.UPDATE_MAP_PROVIDER;
        int out = jdbcTemplate.update(query,
                item.getName(),
                item.getCoordSysName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot update " + item.toString());
        }

        return item;
    }

    @Override
    public MapProvider remove(MapProvider item) {
        String query = QueriesRepository.DELETE_MAP_PROVIDER;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public MapProvider getById(long id) {
        String query = QueriesRepository.GET_MAP_PROVIDER_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_PROVIDERS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<MapProvider> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in MAP_PROVIDER table.
     */
    private long getNewMapProviderId(){
        String query = QueriesRepository.GET_NEW_ID_MAP_PROVIDERS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
