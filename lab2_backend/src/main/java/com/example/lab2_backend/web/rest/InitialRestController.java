package com.example.lab2_backend.web.rest;

import com.example.lab2_backend.model.Books;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class InitialRestController {

    @GetMapping
    public String getBooks(){
        return "Book Shop";
    }
}
