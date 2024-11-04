package com.vedruna.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import com.vedruna.pruebaTecnica.dto.CountryDTO;
import com.vedruna.pruebaTecnica.services.CountryServiceI;
import com.vedruna.pruebaTecnica.services.CountryServiceImpl;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CountryServiceI countryService;



    @GetMapping(path = "/v1/data/country")
    public CountryDTO[] getCountries() {
        return countryService.searchAllCountries();
    }


    @PostMapping(path = "/v1/data/country")
    public String insertCountry(final @RequestBody CountryDTO c){
        return countryService.addCountry(c);
    }
}
