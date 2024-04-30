package org.example.dbtransactions.normalized.interfaces;

import org.example.dbtransactions.normalized.entity.Country;

import java.util.List;

public interface CountryInteract {

    List<Country> saveCountries(List<Country> countries);

    Country save(Country country);
}
