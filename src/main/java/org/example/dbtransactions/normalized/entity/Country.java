package org.example.dbtransactions.normalized.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    public Country () {}

    public Country (
        String name,
        String code
    ) {
        this.name = name;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, updatable = false)
    protected String code;

    @Column(name = "name", nullable = false, updatable = false)
    protected String name;

    @OneToMany(
        targetEntity = Hospital.class,
        fetch = FetchType.LAZY,
        mappedBy = "country"
    )
    protected List<Hospital> hospitals = new ArrayList<>();
}
