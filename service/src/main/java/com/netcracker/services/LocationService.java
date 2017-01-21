package com.netcracker.services;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.Location;

/**
 * @author logariett.
 */
public interface LocationService {

    Location add(String building, String street, long cityId);
    Location getOrAdd(AddressDto address);
    Location getById(long id);

    void delete(Location location);


}
