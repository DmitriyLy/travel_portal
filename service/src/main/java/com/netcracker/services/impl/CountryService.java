package com.netcracker.services.impl;

import com.netcracker.entities.Country;
import com.netcracker.repositories.impl.CountryRepositoryImpl;
import com.netcracker.services.IService;
import com.netcracker.specifications.impl.AllCountriesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuksi on 07.12.2016.
 */
@Service
@Transactional
public class CountryService implements IService<Country> {

    @Autowired
    private CountryRepositoryImpl countryRepository;

    @Override
    public void save(Country item) {
        countryRepository.add(item);
    }

    @Override
    public void update(Country item) {
        countryRepository.update(item);
    }

    @Override
    public void delete(Country item) {
        countryRepository.remove(item);
    }

    public List<Country> findAll() {
        return countryRepository.query(new AllCountriesSpecification());
    }
}
