package com.netcracker.repositories.impl;

import com.netcracker.exception.DuplicateEntityException;
import com.netcracker.exception.NoSuchEntityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  Test for {@link com.netcracker.repositories.impl.UserRepositoryImpl}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class LabelRepositoryTest {


    @Autowired
    LabelRepositoryImpl labelRepository;

    @Test
    public void addLabelTest(){

    }

    @Test
    public void updateLabelTest(){

    }

    @Test
    public void getByIdLabelTest(){

    }

    @Test
    public void deleteLabelTest(){

    }

    /*@Test(expected = DuplicateEntityException.class)
    public void addDuplicateLabelThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingLabelThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingLabelThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingLabelThrowsException(){

    }*/

}
