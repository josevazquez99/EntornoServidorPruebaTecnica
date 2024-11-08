package com.vedruna.pruebaTecnica.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.pruebaTecnica.persistance.model.Country;


public interface CountryRepository extends JpaRepository<Country, Long> {
}
