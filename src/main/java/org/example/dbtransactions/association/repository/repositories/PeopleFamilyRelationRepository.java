package org.example.dbtransactions.association.repository.repositories;

import org.example.dbtransactions.association.entity.PeopleFamilyRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleFamilyRelationRepository extends JpaRepository<PeopleFamilyRelation, Long> {
}
