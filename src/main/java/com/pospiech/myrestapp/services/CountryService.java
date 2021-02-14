package com.pospiech.myrestapp.services;

import com.pospiech.myrestapp.api.model.CountryDTO;

import java.util.List;

public interface CountryService {

    CountryDTO getCountryById(Long id);

    List<CountryDTO> getCountryByName(String name);

    List<CountryDTO> getCountryByCountryCode(String countryCode);

    CountryDTO createNewCountry(CountryDTO countryDTO);

    CountryDTO updateCountry(Long id, CountryDTO countryDTO);

    void deleteCountryById(Long id);
}
