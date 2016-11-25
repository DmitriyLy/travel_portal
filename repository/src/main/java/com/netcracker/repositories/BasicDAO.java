package com.netcracker.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Oveian Egor
 */

@Repository
public class BasicDAO {

    @Autowired
    private JdbcTemplate template;

    String sql = "SELECT JOB_TITLE FROM JOBS WHERE MIN_SALARY = 10000";

    public String getSome() throws DataAccessException {
        return this.template.queryForObject(sql,null,String.class);
    }
}