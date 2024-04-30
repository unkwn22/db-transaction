package org.example.dbtransactions.normalized.repository.repositories;

import org.example.dbtransactions.normalized.entity.Care;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRepository extends JpaRepository<Care, Long> {
}
