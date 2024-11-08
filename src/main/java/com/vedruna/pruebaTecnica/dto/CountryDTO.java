package com.vedruna.pruebaTecnica.dto;

public class CountryDTO {

    private String country;
    private Long population;

    public CountryDTO() {
    }

    public CountryDTO(String country, Long population) {
        this.country = country;
        this.population = population;
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
