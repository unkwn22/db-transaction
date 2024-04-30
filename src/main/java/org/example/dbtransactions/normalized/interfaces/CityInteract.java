package org.example.dbtransactions.normalized.interfaces;

import org.example.dbtransactions.normalized.entity.City;

import java.util.List;

public interface CityInteract {

    List<City> saveCities(List<City> cities);
}
