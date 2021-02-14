package com.pospiech.myrestapp.services;

import com.pospiech.myrestapp.repositories.CountryRepository;
import com.pospiech.myrestapp.api.mapper.CountryMapper;
import com.pospiech.myrestapp.api.model.CountryDTO;
import com.pospiech.myrestapp.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    CountryRepository countryRepository;
    CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryMapper.countryToCountryDTO(countryRepository.findById(id).get());
    }

    @Override
    public List<CountryDTO> getCountryByName(String name) {
        return countryRepository.getCountryByName(name)
                .stream()
                .map(countryMapper::countryToCountryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> getCountryByCountryCode(String countryCode) {
        return countryRepository.getCountryByCountryCode(countryCode)
                .stream()
                .map(countryMapper::countryToCountryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDTO createNewCountry(CountryDTO countryDTO) {
        Country country = countryMapper.countryDTOToCountry(countryDTO);
        Country savedCountry = countryRepository.save(country);

        return countryMapper.countryToCountryDTO(savedCountry);
    }

    @Override
    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        Country country = countryMapper.countryDTOToCountry(countryDTO);
        country.setId(id);

        Country savedCountry = countryRepository.save(country);

        return countryMapper.countryToCountryDTO(savedCountry);
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteCountryById(id);
    }
}
