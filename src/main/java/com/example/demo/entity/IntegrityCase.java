package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Long getId() { return id; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
}
