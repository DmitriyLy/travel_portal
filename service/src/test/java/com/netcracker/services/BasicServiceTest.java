package com.netcracker.services;

import com.netcracker.services.impl.BasicServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/app-context.xml"})
public class BasicServiceTest {

    @Autowired
    BasicServiceImpl basicService;

    @Test
    public void basicServiceImplTest(){
        String s = "President";
        assertEquals(s, basicService.basicMethod());
    }

}
