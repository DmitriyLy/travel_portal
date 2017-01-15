package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
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

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CountryRepositoryTest {

    /*

    @Autowired
    CountryRepositoryImpl countryRepository;
    Country country = new Country();

    @Test
    public void addCountryTest(){
        country.setName("TEST");

        long countOfCountryTableRows = countryRepository.getColumnCount();
        country = countryRepository.add(country);

        assertThat(countryRepository.getColumnCount(), is(countOfCountryTableRows + 1));
    }

    @Test
    public void updateCountryTest(){
        country.setName("NEWTEST");

        assertThat(countryRepository.update(country), is(country));
    }

    @Test
    public void getByIdCountryTest(){
        assertThat(countryRepository.getById(country.getId()), is(country));
    }

    @Test
    public void deleteCountryTest(){
        long countOfCountryTableRows = countryRepository.getColumnCount();
        countryRepository.remove(country);

        assertThat(countryRepository.getColumnCount(), is(countOfCountryTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateCountryThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingCountryThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingCountryThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingCountryThrowsException(){

    }
    */

}
