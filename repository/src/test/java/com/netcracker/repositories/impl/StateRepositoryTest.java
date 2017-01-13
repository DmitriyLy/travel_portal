package com.netcracker.repositories.impl;

import com.netcracker.entities.State;
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
 *  Test for {@link com.netcracker.repositories.impl.UserRepositoryImpl}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class StateRepositoryTest {

    @Autowired
    StateRepositoryImpl stateRepository;
    State state = new State();

    @Test
    public void addStateTest(){
        state.setName("TEST");
        state.setCountryId(1);

        long countOfStateTableRows = stateRepository.getColumnCount();
        state = stateRepository.add(state);

        assertThat(stateRepository.getColumnCount(), is(countOfStateTableRows + 1));
    }

    @Test
    public void updateStateTest(){
        state.setName("NEWTEST");

        assertThat(stateRepository.update(state), is(state));
    }

    @Test
    public void getByIdStateTest(){
        assertThat(stateRepository.getById(state.getId()), is(state));
    }

    @Test
    public void deleteStateTest(){
        long countOfStateTableRows = stateRepository.getColumnCount();
        stateRepository.remove(state);

        assertThat(stateRepository.getColumnCount(), is(countOfStateTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateStateThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingStateThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingStateThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingStateThrowsException(){

    }

}
