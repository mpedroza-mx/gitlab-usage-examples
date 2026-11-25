package org.learning.spring.spring_boot_jpa.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.learning.spring.spring_boot_jpa.dto.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/countries")
public class CountryController {

  private final static List<Country> COUNTRIES;

  static {
    COUNTRIES = Stream.of(new Country().setId(1L).setCountry("Mexico"),
        new Country().setId(2L).setCountry("Colombia"),
        new Country().setId(3L).setCountry("Brazil")).collect(Collectors.toList());
  }

  @GetMapping
  public ResponseEntity listAllCountries() {
    return ResponseEntity.ok(COUNTRIES);
  }

  @GetMapping(path = "{countryName}")
  public ResponseEntity getCountryByName(@PathVariable(name = "countryName") String countryName) {
    Country result = COUNTRIES.stream().filter(country -> country.getCountry().equals(countryName)).findFirst()
        .orElse(null);
    return ResponseEntity.ok(result);
  }

}
