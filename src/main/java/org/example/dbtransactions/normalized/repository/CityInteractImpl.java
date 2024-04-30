package org.example.dbtransactions.normalized.repository;

import org.example.dbtransactions.normalized.entity.City;
import org.example.dbtransactions.normalized.interfaces.CityInteract;
import org.example.dbtransactions.normalized.repository.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityInteractImpl implements CityInteract {

    private final CityRepository cityRepository;

    public CityInteractImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> saveCities(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
}
