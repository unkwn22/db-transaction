package org.example.dbtransactions.normalized.repository.repositories;

import org.example.dbtransactions.normalized.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
