package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caseType;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCaseType() { return caseType; }
    public void setCaseType(String caseType) { this.caseType = caseType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
