package com.example.lab2_backend.service.Int;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAllAuthors();
    Author create(String name, String surname, Country country);
   Optional<Author> getById(Long id);

}
