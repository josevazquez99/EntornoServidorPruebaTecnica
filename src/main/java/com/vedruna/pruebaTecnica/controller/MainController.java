package com.vedruna.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.vedruna.pruebaTecnica.dto.CountryDTO;
import com.vedruna.pruebaTecnica.services.CountryServiceI;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CountryServiceI countryService;

    @GetMapping(path = "/v1/data/country")
    public ResponseEntity<Page<CountryDTO>> getCountries(Pageable pageable) { 
        return ResponseEntity.ok(countryService.searchAllCountries(pageable));
    }

    @PostMapping(path = "/v1/data/country")
    public ResponseEntity<String> insertCountry() {
        countryService.addCountry();  
        return ResponseEntity.ok("Country added successfully");
    }
}
