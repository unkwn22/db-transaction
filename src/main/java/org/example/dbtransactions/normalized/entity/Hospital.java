package org.example.dbtransactions.normalized.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    public Hospital() {}

    public Hospital(
        String name,
        Care care,
        Country country,
        SubjectTreatment subjectTreatment
    ) {
        this.name = name;
        this.care = care;
        this.country = country;
        this.subjectTreatment = subjectTreatment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    protected String name;

    @ManyToOne(
        targetEntity = Care.class,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "care_id")
    protected Care care = new Care();

    @ManyToOne(
        targetEntity = Country.class,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "country_id")
    protected Country country = new Country();

    @ManyToOne(
        targetEntity = SubjectTreatment.class,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "subject_treatment_id")
    protected SubjectTreatment subjectTreatment = new SubjectTreatment();
}
