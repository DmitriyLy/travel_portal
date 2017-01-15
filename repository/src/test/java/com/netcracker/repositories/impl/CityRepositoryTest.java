package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
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
 * Test for {@link com.netcracker.repositories.impl.CityRepositoryImpl}
 * <p>
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CityRepositoryTest {

    /*

    @Autowired
    CityRepositoryImpl cityRepository;
    City city = new City();

    @Test
    public void addCityTest() {
        city.setStateId(1);
        city.setName("TEST");

        long countOfCityTableRows = cityRepository.getColumnCount();
        city = cityRepository.add(city);

        assertThat(cityRepository.getColumnCount(), is(countOfCityTableRows + 1));
    }

    @Test
    public void updateCityTest() {
        city.setName("NEWTEST");

        assertThat(cityRepository.update(city), is(city));
    }

    @Test
    public void getByIdCityTest() {
        assertThat(cityRepository.getById(city.getId()), is(city));
    }

    @Test
    public void deleteCityTest() {
        long countOfCityTableRows = cityRepository.getColumnCount();
        cityRepository.remove(city);

        assertThat(cityRepository.getColumnCount(), is(countOfCityTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateCityThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingCityThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingCityThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingCityThrowsException() {

    }

    */
}
