package com.netcracker.services.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/service-context.xml"})
public class LabelServiceTest {

    @Autowired
    LabelService labelService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getJsonForFullLabelInfoWithIdOne() throws Exception {
        String jsonString = labelService.getFullLabelInfoJson(1);
        assertTrue(!jsonString.isEmpty());
        System.out.println(jsonString);
    }

}