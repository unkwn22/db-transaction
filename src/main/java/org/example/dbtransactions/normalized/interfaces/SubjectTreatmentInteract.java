package org.example.dbtransactions.normalized.interfaces;

import org.example.dbtransactions.normalized.entity.SubjectTreatment;

import java.util.List;

public interface SubjectTreatmentInteract {

    List<SubjectTreatment> saveSubjectTreatments(List<SubjectTreatment> subjectTreatments);

    SubjectTreatment save(SubjectTreatment subjectTreatment);
}
