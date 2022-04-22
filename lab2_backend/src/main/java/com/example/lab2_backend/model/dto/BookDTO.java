package com.example.lab2_backend.model.dto;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.enumeration.Category;
import lombok.Data;



@Data
public class BookDTO {

    String name;

    Category category;


    Long author;

    Integer availableCopies;

    public BookDTO(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
