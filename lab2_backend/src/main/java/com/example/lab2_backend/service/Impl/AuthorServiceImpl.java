package com.example.lab2_backend.service.Impl;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Country;
import com.example.lab2_backend.repository.AuthorRepository;
import com.example.lab2_backend.service.Int.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname,country);
        this.authorRepository.save(author);

        return author;
    }

    @Override
    public Optional<Author> getById(Long id) {
        return this.authorRepository.findById(id);
    }
}
