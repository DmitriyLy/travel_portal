package com.netcracker.services.impl;

import com.netcracker.exception.ConfigurationOptionNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by dima_2 on 05.02.2017.
 */

/**
 *  Test for {@link com.netcracker.services.ConfigurationService}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service-context.xml"})
public class ConfigurationServiceImplTest {

    @Autowired
    private ConfigurationServiceImpl service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getValueUploadedImageDir() throws Exception {
        /*try {
            System.out.println(service.getOptionValueByKey("uploaded_images_dir"));
        } catch (ConfigurationOptionNotFoundException e) {
            System.out.println("Option is not set.");
        }*/
    }

    @Test
    public void testGetUploadedImageDir() throws Exception {
        /*try {
            System.out.println(service.getUploadedImageDir());
        } catch (ConfigurationOptionNotFoundException e) {
            System.out.println("Option is not set.");
        }*/
    }


}