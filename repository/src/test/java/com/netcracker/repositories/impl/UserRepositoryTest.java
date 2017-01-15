package com.netcracker.repositories.impl;

import com.netcracker.entities.User;
import com.netcracker.exception.DuplicateEntityException;
import com.netcracker.exception.NoSuchEntityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Test for {@link com.netcracker.repositories.impl.UserRepositoryImpl}
 * <p>
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class UserRepositoryTest {

    /*

    @Autowired
    UserRepositoryImpl userRepository;
    User user = new User();

    @Test
    public void addUserTest() {
        user.setFirstName("TEST");
        user.setLastName("TEST");
        user.setSocNetUserId("TEST");
        user.setSocialNetworkId(1);
        user.setStatus(0);

        long countOfUserTableRows = userRepository.getColumnCount();
        user = userRepository.add(user);

        assertThat(userRepository.getColumnCount(), is(countOfUserTableRows + 1));
    }

    @Test
    public void updateUserTest() {
        user.setFirstName("NEWTEST");

        assertThat(userRepository.update(user), is(user));
    }

    @Test
    public void getByIdUserTest() {
        assertThat(userRepository.getById(user.getId()), is(user));
    }

    @Test
    public void deleteUserTest() {
        long countOfUserTableRows = userRepository.getColumnCount();
        userRepository.remove(user);

        assertThat(userRepository.getColumnCount(), is(countOfUserTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateUserThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingUserThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingUserThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingUserThrowsException() {

    }

    */

}
