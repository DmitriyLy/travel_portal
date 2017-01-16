package com.netcracker.repositories.impl;

import com.netcracker.entities.Location;
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
public class LocationRepositoryTest {

    @Autowired
    LocationRepositoryImpl locationRepository;
    Location location = new Location();

    @Test
    public void addLocationTest(){
       /* location.setCityId(1);
        location.setStreet("TEST");
        location.setBuilding("TEST");

        long countOfLocationTableRows = locationRepository.getColumnCount();
        location = locationRepository.add(location);

        assertThat(locationRepository.getColumnCount(), is(countOfLocationTableRows + 1));*/
    }

    @Test
    public void updateLocationTest(){
        /*location.setStreet("NEWTEST");

        assertThat(locationRepository.update(location), is(location));*/
    }

    @Test
    public void getByIdLocationTest(){
        //assertThat(locationRepository.getById(location.getId()), is(location));
    }

    @Test
    public void deleteLocationTest(){
        /*long countOfLocationTableRows = locationRepository.getColumnCount();
        locationRepository.remove(location);

        assertThat(locationRepository.getColumnCount(), is(countOfLocationTableRows - 1));*/
    }

    /*@Test(expected = DuplicateEntityException.class)
    public void addDuplicateLocationThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingLocationThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingLocationThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingLocationThrowsException(){

    }*/
}
