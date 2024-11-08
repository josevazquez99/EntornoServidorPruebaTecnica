package com.vedruna.pruebaTecnica.services;

import com.vedruna.pruebaTecnica.dto.CountryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CountryServiceI {

    Page<CountryDTO> searchAllCountries(Pageable pageable);
       //CartDTO[] searchCarts();

    String addCountry();
}