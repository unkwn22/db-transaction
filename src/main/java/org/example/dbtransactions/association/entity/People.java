package org.example.dbtransactions.association.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class People {

    public People() {}

    public People(
        String name
    ) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    protected String name;

    @OneToMany(
        targetEntity = PeopleFamilyRelation.class,
        fetch = FetchType.LAZY,
        mappedBy = "people"
    )
    protected List<PeopleFamilyRelation> peopleRelations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PeopleFamilyRelation> getPeopleRelations() {
        return peopleRelations;
    }
}
