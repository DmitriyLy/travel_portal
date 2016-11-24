package com.netcracker.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Oveian Egor
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class BasicDAOTest {

    @Autowired
    BasicDAO basicDAO;

    @Test
    public void basicTestMethod() {
        try {
            System.out.println(basicDAO.getSome());
        } catch (DataAccessException e){
            System.out.println(e.getMessage());
        }
    }
}
