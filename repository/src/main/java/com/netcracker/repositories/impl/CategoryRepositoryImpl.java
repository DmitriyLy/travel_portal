package com.netcracker.repositories.impl;

import com.netcracker.entities.Category;
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
public class CategoryRepositoryImpl implements IRepository<Category> {

    private final static Logger LOGGER = LogManager.getLogger(CategoryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Category add(Category item) {
        String query = QueriesRepository.INSERT_CATEGORY;
        int out = jdbcTemplate.update(query,
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert category " + item.getName());
        }

        return item;
    }

    @Override
    public Category update(Category item) {
        String query = QueriesRepository.UPDATE_CATEGORY;
        int out = jdbcTemplate.update(query, new Object[]{item.getId(), item.getName()});

        if (out == 0) {
            LOGGER.warn("Could not update category " + item.getName());
        }

        return item;
    }

    @Override
    public Category remove(Category item) {
        String query = QueriesRepository.DELETE_CATEGORY;
        int out = jdbcTemplate.update(query, new Object[]{item.getId()});

        if (out == 0) {
            LOGGER.warn("Could not delete category " + item.getName());
        }

        return item;
    }

    @Override
    public Category getById(long id) {
        String query = QueriesRepository.GET_CATEGORY_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            return category;
        });
    }

    @Override
    public List<Category> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), (rs, rowNum) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            return category;
        });
    }
}
