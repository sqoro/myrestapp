package com.pospiech.myrestapp.repositories;

import com.pospiech.myrestapp.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> getCountryByName(String name);

    List<Country> getCountryByCountryCode(String countryCode);

    void deleteCountryById(Long id);
}
