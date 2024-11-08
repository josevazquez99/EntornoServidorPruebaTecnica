package com.vedruna.pruebaTecnica.persistance.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryResponse {

    private Name name;
    private int population;
    @Data
    public static class Name {
        private String common;
    }


}
