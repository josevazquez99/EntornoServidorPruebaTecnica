package com.vedruna.pruebaTecnica.services;

import com.vedruna.pruebaTecnica.dto.CountryDTO;

public interface CountryServiceI {

    CountryDTO[] searchAllCountries();
    //CartDTO[] searchCarts();

    String addCountry(CountryDTO c);
}