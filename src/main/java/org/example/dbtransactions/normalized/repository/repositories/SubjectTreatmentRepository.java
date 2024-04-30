package org.example.dbtransactions.normalized.repository.repositories;

import org.example.dbtransactions.normalized.entity.SubjectTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTreatmentRepository extends JpaRepository<SubjectTreatment, Long> {
}
