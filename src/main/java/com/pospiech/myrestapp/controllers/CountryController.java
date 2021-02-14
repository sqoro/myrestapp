package com.pospiech.myrestapp.controllers;

import com.pospiech.myrestapp.api.model.CountryDTO;
import com.pospiech.myrestapp.api.model.CountryListDTO;
import com.pospiech.myrestapp.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/country/")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return new ResponseEntity<CountryDTO>(countryService.getCountryById(id), HttpStatus.OK);
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<CountryListDTO> getCountryByName(@PathVariable String name) {
        return new ResponseEntity<CountryListDTO>(
                new CountryListDTO(countryService.getCountryByName(name)), HttpStatus.OK
        );
    }

    @GetMapping("findByCountryCode/{countryCode}")
    public ResponseEntity<CountryListDTO> getCountryByCountryCode(@PathVariable String countryCode) {
        return new ResponseEntity<CountryListDTO>(
                new CountryListDTO(countryService.getCountryByCountryCode(countryCode)), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CountryDTO> createNewCountry(@RequestBody CountryDTO countryDTO) {
        return new ResponseEntity<CountryDTO>(countryService.createNewCountry(countryDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        return new ResponseEntity<CountryDTO>(countryService.updateCountry(id, countryDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
