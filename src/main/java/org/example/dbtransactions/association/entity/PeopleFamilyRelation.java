package org.example.dbtransactions.association.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "people_family_relation")
public class PeopleFamilyRelation {

    public PeopleFamilyRelation() {}

    public PeopleFamilyRelation(
        People people,
        Family family
    ) {
        this.people = people;
        this.family = family;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(
        fetch = FetchType.LAZY,
        targetEntity = People.class
    )
    @JoinColumn(name = "people_id", nullable = false, updatable = false)
    protected People people;

    @ManyToOne(
        fetch = FetchType.LAZY,
        targetEntity = Family.class
    )
    @JoinColumn(name = "family_id", nullable = false, updatable = false)
    protected Family family;

    public Long getId() {
        return id;
    }

    public People getPeople() {
        return people;
    }

    public Family getFamily() {
        return family;
    }
}
