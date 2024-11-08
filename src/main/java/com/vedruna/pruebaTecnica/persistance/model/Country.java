package com.vedruna.pruebaTecnica.persistance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private Long population;

    public Long getId() {            
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }
    public void setPopulation(Long population) {
        this.population = population;
    }

}
