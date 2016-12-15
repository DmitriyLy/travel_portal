package com.netcracker.repositories.impl;

import com.netcracker.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class UserRepositoryTest {

    User user = new User();

    @Before
    public void fillUserFields(){
        user.setFirstName("SomeTestFirstName");
        user.setLastName("SomeTestLastName");
        user.setSocNetUserId("SomeTestSocNetUserId");
        user.setSocialNetworkId(1);
        user.setStatus(0);
    }

    @Test
    public void addUserTest(){}

    @Test
    public void updateUserTest(){}

    @Test
    public void getByIdUserTest(){}

    @Test
    public void removeUserTest(){}

}
