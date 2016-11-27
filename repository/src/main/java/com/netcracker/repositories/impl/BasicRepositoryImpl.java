package com.netcracker.repositories.impl;

import com.netcracker.entities.BasicEntity;
import com.netcracker.repositories.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BasicRepositoryImpl implements BasicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BasicEntity getBasicEntity() {
        String sql = "SELECT JOB_TITLE FROM JOBS WHERE MIN_SALARY = 20000";
        BasicEntity basicEntity = new BasicEntity();
        basicEntity.setBasicField(this.jdbcTemplate.queryForObject(sql,null,String.class));
        return basicEntity;
    }
}
