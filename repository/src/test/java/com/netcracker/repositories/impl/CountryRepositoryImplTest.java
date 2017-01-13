package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
import com.netcracker.repositories.IRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CountryRepositoryImplTest {

    @Autowired
    CountryRepositoryImpl countryRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void getByFirstIdEqualsItaly() {
        /*Country italy = new Country(1, "Italy");
        Country country = countryRepository.getById(1);
        Assert.assertEquals(italy, country);*/
    }

    @Test
    public void query() throws Exception {

    }

}