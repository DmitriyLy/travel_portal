package com.netcracker.services;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.Country;

/**
 * @author logariett.
 */
public interface CountryService {

    Country add(String countryName);
    Country getOrAdd(AddressDto address);
    Country getById(long id);

    void delete(Country country);


}
