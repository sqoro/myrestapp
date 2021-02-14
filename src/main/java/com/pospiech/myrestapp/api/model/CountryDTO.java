package com.pospiech.myrestapp.api.model;

import lombok.Data;

@Data
public class CountryDTO {
    Long id;
    String name;
    String countryCode;
}
