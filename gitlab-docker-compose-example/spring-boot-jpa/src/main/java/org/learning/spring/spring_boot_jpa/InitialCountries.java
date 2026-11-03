package org.learning.spring.spring_boot_jpa;

import java.util.List;

public class InitialCountries {
    public static final List<Country>
            NORTH_AMERICA_COUNTRIES = List.of(
            new Country(InitialContinents.NORTH_AMERICA, "Canada", 37742154L),
            new Country(InitialContinents.NORTH_AMERICA, "United States", 79294227L),
            new Country(InitialContinents.NORTH_AMERICA, "Mexico", 130220689L),
            new Country(InitialContinents.SOUTH_AMERICA, "Brazil", 212559417L),
            new Country(InitialContinents.SOUTH_AMERICA, "Argentina", 45195774L),
            new Country(InitialContinents.SOUTH_AMERICA, "Peru", 33103775L),
            new Country(InitialContinents.EUROPE, "Germany", 83190556L),
            new Country(InitialContinents.EUROPE, "France", 67032000L),
            new Country(InitialContinents.EUROPE, "Italy", 59138600L),
            new Country(InitialContinents.EUROPE, "United Kingdom", 67886018L));
}