package com.netcracker.repositories.impl;

import com.netcracker.entities.Category;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.CategoryRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


/**
 * Created by dima_2 on 30.11.2016.
 */
public class CategoryRepositoryImpl implements IRepository<Category> {

    private final static Logger LOGGER = LogManager.getLogger(CategoryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CategoryRowMapper categoryRowMapper;

    @Override
    public void add(Category item) {
        String query = IQueriesRepository.INSERT_CATEGORY;
        int out = jdbcTemplate.update(query, new Object[]{item.getName()});
        if (out == 0)
            LOGGER.warn("Could not insert category " + item.getName());
    }

    @Override
    public void update(Category item) {
        String query = IQueriesRepository.UPDATE_CATEGORY;
        int out = jdbcTemplate.update(query, new Object[]{item.getId(), item.getName()});
        if (out == 0)
            LOGGER.warn("Could not update category " + item.getName());
    }

    @Override
    public void remove(Category item) {
        String query = IQueriesRepository.DELETE_CATEGORY;
        int out = jdbcTemplate.update(query, new Object[]{item.getId()});
        if (out == 0)
            LOGGER.warn("Could not delete category " + item.getName());
    }

    @Override
    public Category getById(long id) {
        String query = IQueriesRepository.GET_CATEGORY_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, categoryRowMapper);
    }

    @Override
    public List<Category> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), categoryRowMapper);
    }
}
