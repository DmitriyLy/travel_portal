package com.netcracker.services;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.State;

/**
 * @author logariett.
 */
public interface StateService {

    State add(String stateName, long countryId);
    State getOrAdd(AddressDto address);
    State getById(long id);

    void delete(State state);

}
