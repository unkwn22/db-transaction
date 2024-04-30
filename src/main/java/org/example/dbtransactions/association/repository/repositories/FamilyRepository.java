package org.example.dbtransactions.association.repository.repositories;

import org.example.dbtransactions.association.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long> {
}
