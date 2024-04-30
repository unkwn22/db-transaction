package org.example.dbtransactions.normalized.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "care")
public class Care {

    public Care() {}

    public Care(
        int type,
        String typeName
    ) {
        this.type = type;
        this.typeName = typeName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false, updatable = false)
    protected int type;

    @Column(name = "type_name", nullable = false, updatable = false)
    protected String typeName;

    @OneToMany(
        targetEntity = Hospital.class,
        fetch = FetchType.LAZY,
        mappedBy = "care"
    )
    protected List<Hospital> hospitals = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }
}
