package com.vedruna.pruebaTecnica.dto;

public class CountryDTO {

    private String country;
    private int population;



    public CountryDTO() {
    }

    public CountryDTO(String country, int population) {
        this.country = country;
        this.population = population;
    }

    public String getCountry() {            
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {        
        this.population = population;
    }
}
