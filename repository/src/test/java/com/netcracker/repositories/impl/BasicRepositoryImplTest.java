package com.netcracker.repositories.impl;

import com.netcracker.entities.BasicEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/app-context.xml"})
public class BasicRepositoryImplTest {

    @Autowired
    BasicRepositoryImpl basicRepository;

    @Test
    public void getBasicEntityTest(){
        BasicEntity basicEntity = new BasicEntity();
        basicEntity.setBasicField("President");
        assertEquals(basicEntity, basicRepository.getBasicEntity());
    }

}
