package com.netcracker.repositories.impl;

import com.netcracker.entities.FullLabelInfo;
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
public class FullLabelInfoRepositoryImpl implements IRepository<FullLabelInfo> {

    private final static Logger LOGGER = LogManager.getLogger(FullLabelInfoRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<FullLabelInfo> mapper = (rs, rowNum) -> {
        FullLabelInfo fullLabelInfo = new FullLabelInfo();
        fullLabelInfo.setId(rs.getLong("id"));
        fullLabelInfo.setOwnerName(rs.getString("owner_name"));
        fullLabelInfo.setCreationDate(rs.getString("creation_date"));
        fullLabelInfo.setCoordLat(rs.getDouble("coordinate_lat"));
        fullLabelInfo.setCoordLong(rs.getDouble("coordinate_long"));
        fullLabelInfo.setMapProvider(rs.getString("map_provider"));
        fullLabelInfo.setBuilding(rs.getString("building"));
        fullLabelInfo.setStreet(rs.getString("street"));
        fullLabelInfo.setCity(rs.getString("city"));
        fullLabelInfo.setState(rs.getString("state"));
        fullLabelInfo.setCountry(rs.getString("country"));
        return fullLabelInfo;
    };

    @Override
    public FullLabelInfo add(FullLabelInfo item) {
        return item;
    }

    @Override
    public FullLabelInfo update(FullLabelInfo item) {
        return item;
    }

    @Override
    public FullLabelInfo remove(FullLabelInfo item) {
        return item;
    }

    @Override
    public FullLabelInfo getById(long id) {
        String query = QueriesRepository.GET_FULL_LABEL_INFO_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        return 0;
    }

    @Override
    public List<FullLabelInfo> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }
}
