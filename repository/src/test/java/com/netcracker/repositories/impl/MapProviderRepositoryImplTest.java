package com.netcracker.repositories.impl;

import com.netcracker.entities.MapProvider;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.MapProviderByName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dima_2 on 11.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class MapProviderRepositoryImplTest {

    @Autowired
    private MapProviderRepositoryImpl mapProviderRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addRemoveTestProvider() throws Exception {

        SqlSpecification specification = new MapProviderByName("test.net");

        List<MapProvider> list = mapProviderRepository.query(specification);

        for (MapProvider item : list) {
            mapProviderRepository.remove(item);
        }

        MapProvider expMapProvider = new MapProvider();
        expMapProvider.setName("test.net");
        expMapProvider.setCoordSysName("Unknown");
        mapProviderRepository.add(expMapProvider);

        list = mapProviderRepository.query(specification);

        assertEquals(1, list.size());

        MapProvider actMapProvider = list.get(0);

        expMapProvider.setId(actMapProvider.getId());

        assertEquals(expMapProvider, actMapProvider);
        assertEquals(expMapProvider.getCoordSysName(), actMapProvider.getCoordSysName());

        mapProviderRepository.remove(expMapProvider);

        list = mapProviderRepository.query(specification);

        assertEquals(0, list.size());

    }

    @Test
    public void update() throws Exception {

        SqlSpecification specification = new MapProviderByName("google.com");

        List<MapProvider> list = mapProviderRepository.query(specification);

        if (list.size() == 0) {
            fail("google.com not found");
        }

        list.get(0).setName("test.net");
        mapProviderRepository.update(list.get(0));

        assertEquals(0, mapProviderRepository.query(specification).size());

        list.get(0).setName("google.com");
        mapProviderRepository.update(list.get(0));

        assertEquals(1, mapProviderRepository.query(specification).size());

    }

    @Test
    public void getGoogleById() throws Exception {
        MapProvider expectedProvider1 = new MapProvider(1, "google.com", "EPSG 3785");
        MapProvider expectedProvider2 = new MapProvider(1, "google.com", "Unknown");
        MapProvider actualProvider = mapProviderRepository.getById(1);

        assertEquals(expectedProvider1, actualProvider);
        assertEquals(expectedProvider2, actualProvider);
    }

    @Test
    public void getGoogle() throws Exception {
        List<MapProvider> list = mapProviderRepository.query(new MapProviderByName("google.com"));

        assertEquals(1, list.size());
    }

}