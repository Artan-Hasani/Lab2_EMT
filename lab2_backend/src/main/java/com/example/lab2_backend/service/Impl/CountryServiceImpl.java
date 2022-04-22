package com.example.lab2_backend.service.Impl;

import com.example.lab2_backend.model.Country;
import com.example.lab2_backend.repository.CountryRepository;
import com.example.lab2_backend.service.Int.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        this.countryRepository.save(country);
        return country;
    }
}
