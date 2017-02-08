package com.netcracker.services.impl;

import com.netcracker.dto.AddressDto;
import com.netcracker.entities.Country;
import com.netcracker.repositories.impl.CountryRepositoryImpl;
import com.netcracker.services.CountryService;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.impl.CountryByName;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class CountryServiceImpl implements CountryService {
    private final static Logger LOGGER = LogManager.getLogger(CountryServiceImpl.class.getName());

    @Autowired
    private CountryRepositoryImpl countryRepository;


    @Override
    public Country add(String countryName) {
        Country country = new Country();
        country.setName(countryName);
        return countryRepository.add(country);
    }

    @Override
    public Country getById(long id) {
        return countryRepository.getById(id);
    }

    @Override
    public Country getOrAdd(AddressDto address) {
        List<Country> country = countryRepository.query(new CountryByName(address.getCountry()));

        if (country.isEmpty())
            return add(address.getCountry());
        else if (country.size() == 1) {
            return country.get(0);
        } else {
            // throw smth
        }
        return null;
    }

    @Override
    public void delete(Country country) {
        countryRepository.remove(country);
    }
}
