package com.pospiech.myrestapp.api.mapper;

import com.pospiech.myrestapp.api.model.CountryDTO;
import com.pospiech.myrestapp.domain.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryMapperTest {
    CountryMapper countryMapper = CountryMapper.INSTANCE;
    @Test
    void countryToCountryDTO() {
        Country poland = new Country();
        poland.setId(1L);
        poland.setName("poland");
        poland.setCountryCode("PL");
        CountryDTO countryDTO = countryMapper.countryToCountryDTO(poland);
        assertEquals(Long.valueOf(1), countryDTO.getId());
        assertEquals("poland", countryDTO.getName());
        assertEquals("PL", countryDTO.getCountryCode());
    }
}
