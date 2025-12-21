package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PenaltyAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    public Long getId() { return id; }
    public String getAction() { return action; }

    public void setId(Long id) { this.id = id; }
    public void setAction(String action) { this.action = action; }
}
