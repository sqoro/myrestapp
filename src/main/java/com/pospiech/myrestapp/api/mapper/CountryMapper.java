package com.pospiech.myrestapp.api.mapper;

import com.pospiech.myrestapp.domain.Country;
import com.pospiech.myrestapp.api.model.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO countryToCountryDTO(Country country);

    Country countryDTOToCountry(CountryDTO countryDTO);
}
