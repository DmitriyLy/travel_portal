package com.netcracker.services.impl;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.Country;
import com.netcracker.entities.State;
import com.netcracker.repositories.impl.StateRepositoryImpl;
import com.netcracker.services.CountryService;
import com.netcracker.services.StateService;
import com.netcracker.specifications.impl.StateByNameAndCountryId;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author logariett.
 */
@Service
public class StateServiceImpl implements StateService {
    private final static Logger LOGGER = LogManager.getLogger(StateServiceImpl.class.getName());

    @Autowired
    private StateRepositoryImpl stateRepository;
    @Autowired
    private CountryService countryService;

    @Override
    public State add(String stateName, long countryId) {
        State state = new State();
        state.setName(stateName);
        state.setCountryId(countryId);
        return stateRepository.add(state);
    }

    @Override
    public State getOrAdd(AddressDto address) {
        Country country = countryService.getOrAdd(address);

        List<State> state = stateRepository.query(new StateByNameAndCountryId(address.getState(), country.getId()));
        if (state.size() == 0)
            return add(address.getState(), country.getId());
        else if (state.size() == 1) {
            return state.get(0);
        } else {
            // throw smth
        }
        return null;
    }

    @Override
    public State getById(long id) {
        return stateRepository.getById(id);
    }

    @Override
    public void delete(State state) {
        stateRepository.remove(state);
    }


}
