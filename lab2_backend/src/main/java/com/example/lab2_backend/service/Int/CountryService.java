package com.example.lab2_backend.service.Int;

import com.example.lab2_backend.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> listAll();
    Country create(String name, String continent);
}
