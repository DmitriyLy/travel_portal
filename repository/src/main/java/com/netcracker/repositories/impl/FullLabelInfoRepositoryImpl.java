package com.netcracker.repositories.impl;

import com.netcracker.entities.FullLabelInfo;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.RowMapperGenerator;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima_2 on 13.12.2016.
 */
@Repository
public class FullLabelInfoRepositoryImpl implements IRepository<FullLabelInfo> {

    private final static Logger LOGGER = LogManager.getLogger(FullLabelInfoRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;
    @Autowired
    private RowMapperGenerator rowMapperGenerator;

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
        String query = IQueriesRepository.GET_FULL_LABEL_INFO_BY_ID;
        return template.queryForObject(query,new Object[] {id}, rowMapperGenerator.getFullLabelInfoRowMapper());
    }

    @Override
    public List<FullLabelInfo> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), rowMapperGenerator.getFullLabelInfoRowMapper());
    }
}
