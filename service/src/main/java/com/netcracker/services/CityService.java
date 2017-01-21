package com.netcracker.services;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.City;

/**
 * @author logariett.
 */
public interface CityService {

    City add(String cityName, long statementId);
    City getOrAdd(AddressDto address);
    City getById(long id);

    void delete(City city);

}
