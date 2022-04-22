package com.example.lab2_backend.model;

import com.example.lab2_backend.model.enumeration.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(value = EnumType.STRING)
    Category category;

    @ManyToOne
    Author author;

    Integer availableCopies;

    public Books(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Books() {
    }


}
