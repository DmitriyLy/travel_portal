package com.netcracker.repositories.impl;

import com.netcracker.entities.Bookmark;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for  {@link com.netcracker.entities.Bookmark}
 *
 * Created by dima_2 on 30.11.2016.
 */
@Repository
public class BookmarkRepositoryImpl implements IRepository<Bookmark> {

    private final static Logger LOGGER = LogManager.getLogger(BookmarkRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public void add(Bookmark item) {
    }

    @Override
    public void update(Bookmark item) {

    }

    @Override
    public void remove(Bookmark item) {

    }

    @Override
    public Bookmark getById(int id) {
        return null;
    }

    @Override
    public List<Bookmark> query(Specification specification) {
        return null;
    }
}
