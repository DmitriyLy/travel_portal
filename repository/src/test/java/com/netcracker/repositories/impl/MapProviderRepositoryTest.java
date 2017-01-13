package com.netcracker.repositories.impl;

import com.netcracker.entities.MapProvider;
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
public class MapProviderRepositoryTest {

    @Autowired
    MapProviderRepositoryImpl mapProviderRepository;
    MapProvider provider = new MapProvider();

    @Test
    public void addMapProviderTest(){
        provider.setName("TEST");
        provider.setCoordSysName("TEST");

        long countOfMapProviderTableRows = mapProviderRepository.getColumnCount();
        provider = mapProviderRepository.add(provider);

        assertThat(mapProviderRepository.getColumnCount(), is(countOfMapProviderTableRows + 1));
    }

    @Test
    public void updateMapProviderTest(){
        provider.setName("NEWTEST");

        assertThat(mapProviderRepository.update(provider), is(provider));
    }

    @Test
    public void getByIdMapProviderTest(){
        assertThat(mapProviderRepository.getById(provider.getId()), is(provider));
    }

    @Test
    public void deleteMapProviderTest(){
        long countOfMapProviderTableRows = mapProviderRepository.getColumnCount();
        mapProviderRepository.remove(provider);

        assertThat(mapProviderRepository.getColumnCount(), is(countOfMapProviderTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateMapProviderThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingMapProviderThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingMapProviderThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingMapProviderThrowsException(){

    }

}
