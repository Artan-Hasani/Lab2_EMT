package com.example.lab2_backend.config;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.enumeration.Category;

import com.example.lab2_backend.service.Int.AuthorService;
import com.example.lab2_backend.service.Int.BookService;

import com.example.lab2_backend.service.Int.CountryService;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData() throws Exception {

        for (int i=0;i<5;i++)
        {
           Author author = authorService.create("Author"+i,"Author"+i,countryService.create("Country"+i,"Continent"+i));
            bookService.create("Book"+i, Category.DRAMA,author.getId(),i+100);
        }

    }
}
