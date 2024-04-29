package org.example.dbtransactions.normalized.repository.repositories;

import org.example.dbtransactions.normalized.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
