package com.example.lab2_backend.web.rest;

import com.example.lab2_backend.model.Books;
import com.example.lab2_backend.model.Country;
import com.example.lab2_backend.service.Int.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/country")
public class CountryRestController {


    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> getCountries(){
        return countryService.listAll();
    }
}
