package com.example.lab2_backend.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
