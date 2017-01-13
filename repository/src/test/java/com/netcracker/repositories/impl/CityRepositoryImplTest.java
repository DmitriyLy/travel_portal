package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
import com.netcracker.entities.State;
import com.netcracker.specifications.impl.CitiesByName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CityRepositoryImplTest {

    @Autowired
    private CityRepositoryImpl cityRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addOneCity() throws Exception {
        City city = new City();
        city.setName("Test city");
        city.setStateId(1);
        cityRepository.add(city);

        List<City> list = cityRepository.query(new CitiesByName("Test city"));

        assertNotEquals(list.size(), 0);
    }

    @Test
    public void updateTestCity() throws Exception {
        City city = new City();
        city.setName("Test");
        city.setStateId(1);
        cityRepository.add(city);

        List<City> listBeforeUpdate = cityRepository.query(new CitiesByName("Test"));

        for (City item : listBeforeUpdate) {
            item.setName("Test city");
            cityRepository.update(item);
        }

        List<City> listAfterUpdate = cityRepository.query(new CitiesByName("Test city"));

        city.setName("Test city");

        assertEquals(listBeforeUpdate.size(), listAfterUpdate.size());
        assertEquals(city.getName(), listAfterUpdate.get(0).getName());
    }

    @Test
    public void removeTestCities() throws Exception {
        City city = new City();
        city.setName("Test city");
        city.setStateId(1);
        cityRepository.add(city);

        List<City> listBeforeRemove = cityRepository.query(new CitiesByName("Test city"));

        for (City item : listBeforeRemove) {
            cityRepository.remove(item);
        }

        List<City> listAfterRemove = cityRepository.query(new CitiesByName("Test city"));

        assertNotEquals(listBeforeRemove.size(), 0);
        assertEquals(listAfterRemove.size(), 0);
    }

    @Test
    public void getByIdCityOdessa() throws Exception {
        /*City expectedCity = new City(1, "Odessa", 1);
        City actualCity = cityRepository.getById(1);
        assertEquals(expectedCity, actualCity);*/
    }

    @Test
    public void queryGetCitOdessaByName() throws Exception {
        List<City> list = cityRepository.query(new CitiesByName("Odessa"));
        assertEquals(list.size(), 1);
    }

}