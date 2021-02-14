package com.pospiech.myrestapp.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CountryListDTO {
    private List<CountryDTO> countryList;
}
