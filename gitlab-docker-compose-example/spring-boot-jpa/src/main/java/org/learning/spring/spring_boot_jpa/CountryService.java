

package org.learning.spring.spring_boot_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContinentRepository continentRepository;

    public Country createCountry(Country country) {
        Continent continent = continentRepository.findById(country.getContinent().getId())
                .orElseThrow(() -> new RuntimeException("Continent not found"));
        country.setContinent(continent);
        return countryRepository.save(country);
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country updateCountry(Long id, Country updatedCountry) {
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Continent continent = continentRepository.findById(updatedCountry.getContinent().getId())
                .orElseThrow(() -> new RuntimeException("Continent not found"));
        updatedCountry.setId(existingCountry.getId());
        updatedCountry.setContinent(continent);
        return countryRepository.save(updatedCountry);
    }

    public void deleteCountry(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        countryRepository.delete(country);
    }
}