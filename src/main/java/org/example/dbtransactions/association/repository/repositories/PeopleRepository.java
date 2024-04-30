package org.example.dbtransactions.association.repository.repositories;

import org.example.dbtransactions.association.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
