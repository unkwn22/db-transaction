package org.example.dbtransactions.normalized.repository;

import org.example.dbtransactions.normalized.entity.SubjectTreatment;
import org.example.dbtransactions.normalized.interfaces.SubjectTreatmentInteract;
import org.example.dbtransactions.normalized.repository.repositories.SubjectTreatmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectTreatmentInteractImpl implements SubjectTreatmentInteract {

    private final SubjectTreatmentRepository subjectTreatmentRepository;

    public SubjectTreatmentInteractImpl(SubjectTreatmentRepository subjectTreatmentRepository) {
        this.subjectTreatmentRepository = subjectTreatmentRepository;
    }

    @Override
    public List<SubjectTreatment> saveSubjectTreatments(List<SubjectTreatment> subjectTreatments) {
        return subjectTreatmentRepository.saveAll(subjectTreatments);
    }

    @Override
    public SubjectTreatment save(SubjectTreatment subjectTreatment) {
        return subjectTreatmentRepository.save(subjectTreatment);
    }

}
