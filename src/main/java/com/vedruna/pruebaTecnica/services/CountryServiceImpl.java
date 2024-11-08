package com.vedruna.pruebaTecnica.services;

import com.vedruna.pruebaTecnica.dto.CountryDTO;
import com.vedruna.pruebaTecnica.persistance.model.Country;
import com.vedruna.pruebaTecnica.persistance.model.CountryResponse;
import com.vedruna.pruebaTecnica.persistance.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryServiceI {

    private WebClient client = WebClient.create("https://restcountries.com/v3.1");

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Page<CountryDTO> searchAllCountries(Pageable pageable) {
        Page<Country> countries = countryRepository.findAll(pageable);
        List<CountryDTO> countryDTOs = countries.stream()
            .map(c -> new CountryDTO(c.getCountry(), c.getPopulation()))
            .collect(Collectors.toList());
        return new PageImpl<>(countryDTOs, pageable, countries.getTotalElements());
    }

    @Override
    public String addCountry() {
        // Obtener los datos de la API externa y almacenar en la base de datos
        List<CountryResponse> countryList = client.get()
        .uri("/all")
        .retrieve()
        .bodyToFlux(CountryResponse.class)
        .collectList()
        .block();
        for (CountryResponse countryResponse : countryList) {
        Country country = new Country();
        country.setCountry(countryResponse.getName().getCommon());
        country.setPopulation((long) countryResponse.getPopulation());
        countryRepository.save(country);
    }
    return "Datos almacenados exitosamente";
}
}
