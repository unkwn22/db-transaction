package org.example.dbtransactions.normalized.repository.repositories;

import org.example.dbtransactions.normalized.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
