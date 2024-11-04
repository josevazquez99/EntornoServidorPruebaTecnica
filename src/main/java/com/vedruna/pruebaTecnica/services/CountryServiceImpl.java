package com.vedruna.pruebaTecnica.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.vedruna.pruebaTecnica.dto.CountryDTO;

@Service
public class CountryServiceImpl implements CountryServiceI {
    //mas info -> https://www.baeldung.com/spring-5-webclient
    private WebClient client = WebClient.create("https://restcountries.com/");
    @Override
    public CountryDTO[] searchAllCountries() {
        return client.get().uri("/all").retrieve().bodyToMono(CountryDTO[].class).block();
    }

    @Override
    public String addCountry(CountryDTO c) {
        WebClient.ResponseSpec responseSpec = client.post().uri("/ALL").bodyValue(c).retrieve();
        return responseSpec.bodyToMono(String.class).block();
    }
}
