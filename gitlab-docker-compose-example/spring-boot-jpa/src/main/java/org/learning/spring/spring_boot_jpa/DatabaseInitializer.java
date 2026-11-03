package org.learning.spring.spring_boot_jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private ContinentRepository continentRepository;
    @Autowired
    private CountryRepository
            countryRepository;

    @Override

    public void run(String... args) throws Exception {
        continentRepository.
                saveAll(List.of(InitialContinents.NORTH_AMERICA, InitialContinents.SOUTH_AMERICA, InitialContinents.EUROPE, InitialContinents.AFRICA,
                        InitialContinents.ASIA, InitialContinents.AUSTRALIA));
        countryRepository.
                saveAll(InitialCountries.NORTH_AMERICA_COUNTRIES);
    }
}