package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
import com.netcracker.entities.State;
import com.netcracker.specifications.impl.StatesByName;
import com.netcracker.specifications.impl.StatesInCountrySpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by logariett on 29.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class StateRepositoryImplTest {

    @Autowired
    private StateRepositoryImpl stateRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addTestState() throws Exception {
        State state = new State();
        state.setName("Test Crimea");
        state.setCountryId(26);

        List<State> listBeforeName = stateRepository.query(new StatesByName("Test Crimea"));
        List<State> listBeforeCountry = stateRepository.query(new StatesInCountrySpecification(state.getCountryId()));
        stateRepository.add(state);
        List<State> listAfterName = stateRepository.query(new StatesByName("Test Crimea"));
        List<State> listAfterCountry = stateRepository.query(new StatesInCountrySpecification(state.getCountryId()));

        assertTrue((listAfterName.size() - listBeforeName.size()) == 1);
        assertTrue((listAfterCountry.size() - listBeforeCountry.size()) == 1);
    }

    @Test
    public void updateTestState() throws Exception {




    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void query() throws Exception {

    }
}
