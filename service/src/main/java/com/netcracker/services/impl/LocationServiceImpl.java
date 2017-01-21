package com.netcracker.services.impl;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.City;
import com.netcracker.entities.Location;
import com.netcracker.repositories.impl.LocationRepositoryImpl;
import com.netcracker.services.CityService;
import com.netcracker.services.LocationService;
import com.netcracker.specifications.impl.LocationByCityIdStreetBuilding;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class LocationServiceImpl implements LocationService {
    private final static Logger LOGGER = LogManager.getLogger(LocationServiceImpl.class.getName());

    @Autowired
    private LocationRepositoryImpl locationRepository;
    @Autowired
    private CityService cityService;


    @Override
    public Location add(String building, String street, long cityId) {
        Location location = new Location();
        location.setBuilding(building);
        location.setStreet(street);
        location.setCityId(cityId);
        return locationRepository.add(location);
    }

    @Override
    public Location getById(long id) {
        return locationRepository.getById(id);
    }

    @Override
    public void delete(Location location) {
        locationRepository.remove(location);
    }

    @Override
    public Location getOrAdd(AddressDto address) {
        City city = cityService.getOrAdd(address);

        List<Location> location = locationRepository.query(
                new LocationByCityIdStreetBuilding(city.getId(),
                        address.getStreet(),
                        address.getBuilding())
        );
        if (location.size() == 0)
            return add(address.getBuilding(), address.getStreet(), city.getId());
        else if (location.size() == 1) {
            return location.get(0);
        } else {
            // throw smth
        }
        return null;
    }
}
