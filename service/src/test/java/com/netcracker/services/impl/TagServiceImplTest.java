package com.netcracker.services.impl;

import com.netcracker.entities.Tag;
import com.netcracker.services.TagService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dima_2 on 07.02.2017.
 */

/**
 *  Test for {@link com.netcracker.services.TagService}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service-context.xml"})
public class TagServiceImplTest {

    @Autowired
    private TagService tagService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getPopularTags() throws Exception {
        //List<Tag> list = tagService.getPopularTags();
        //System.out.println(tagService.getPopularTags());
    }

}