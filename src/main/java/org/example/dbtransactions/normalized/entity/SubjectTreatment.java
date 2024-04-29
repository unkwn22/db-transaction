package org.example.dbtransactions.normalized.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject_treatment")
public class SubjectTreatment {

    public SubjectTreatment() {}

    public SubjectTreatment(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    protected String name;

    @OneToMany(
        targetEntity = Hospital.class,
        fetch = FetchType.LAZY,
        mappedBy = "subjectTreatment"
    )
    protected List<Hospital> hospitals = new ArrayList<>();
}
