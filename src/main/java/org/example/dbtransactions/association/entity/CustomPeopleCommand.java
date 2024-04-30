package org.example.dbtransactions.association.entity;

import java.util.List;

public class CustomPeopleCommand {
    private Long id;
    private String name;
    private List<CustomFamilyCommand> families;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomFamilyCommand> getFamilies() {
        return families;
    }

    public void setFamilies(List<CustomFamilyCommand> families) {
        this.families = families;
    }
}


