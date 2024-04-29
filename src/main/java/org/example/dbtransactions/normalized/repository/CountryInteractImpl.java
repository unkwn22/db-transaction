package org.example.dbtransactions.normalized.repository;

import org.example.dbtransactions.normalized.entity.Country;
import org.example.dbtransactions.normalized.interfaces.CountryInteract;
import org.example.dbtransactions.normalized.repository.repositories.CountryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryInteractImpl implements CountryInteract {

    private final CountryRepository countryRepository;

    public CountryInteractImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> saveCountries(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
