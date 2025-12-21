package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EvidenceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String evidenceDetails;

    public Long getId() { return id; }
    public String getEvidenceDetails() { return evidenceDetails; }

    public void setId(Long id) { this.id = id; }
    public void setEvidenceDetails(String evidenceDetails) { this.evidenceDetails = evidenceDetails; }
}
