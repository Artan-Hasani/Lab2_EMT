package com.example.lab2_backend.config;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.enumeration.Category;
import com.example.lab2_backend.model.enumeration.Role;
import com.example.lab2_backend.service.Int.AuthorService;
import com.example.lab2_backend.service.Int.BookService;

import com.example.lab2_backend.service.Int.CountryService;
import com.example.lab2_backend.service.Int.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;
    private final UserService userService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService, UserService userService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
        this.userService = userService;
    }


    @PostConstruct
    public void initData() throws Exception {

//        this.userService.register("admin","admin","admin","admin","admin", Role.ROLE_ADMIN);

        for (int i=0;i<5;i++)
        {
           Author author = authorService.create("Author"+i,"Author"+i,countryService.create("Country"+i,"Continent"+i));
            bookService.create("Book"+i, Category.DRAMA,author.getId(),i+100);
        }

    }
}
