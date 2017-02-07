package com.netcracker.services.impl;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.City;
import com.netcracker.entities.State;
import com.netcracker.repositories.impl.CityRepositoryImpl;
import com.netcracker.services.CityService;
import com.netcracker.services.StateService;
import com.netcracker.specifications.impl.CityByNameAndStateId;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class CityServiceImpl implements CityService {
    private final static Logger LOGGER = LogManager.getLogger(CityServiceImpl.class.getName());

    @Autowired
    private CityRepositoryImpl cityRepository;
    @Autowired
    private StateService stateService;


    @Override
    public City add(String cityName, long statementId) {
        City city = new City();
        city.setName(cityName);
        city.setStateId(statementId);
        return cityRepository.add(city);
    }

    @Override
    public City getOrAdd(AddressDto address) {
        State state = stateService.getOrAdd(address);

        List<City> city = cityRepository.query(new CityByNameAndStateId(address.getCity(), state.getId()));
        if (city.isEmpty())
            return add(address.getCity(), state.getId());
        else if (city.size() == 1) {
            return city.get(0);
        } else {
            // throw smth
        }
        return null;
    }

    @Override
    public City getById(long id) {
        return cityRepository.getById(id);
    }

    @Override
    public void delete(City city) {
        cityRepository.remove(city);
    }
}
