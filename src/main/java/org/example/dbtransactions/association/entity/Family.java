package org.example.dbtransactions.association.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family")
public class Family {

    public Family() {}

    public Family(
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
        mappedBy = "family"
    )
    protected List<PeopleFamilyRelation> familyRelations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PeopleFamilyRelation> getFamilyRelations() {
        return familyRelations;
    }
}
