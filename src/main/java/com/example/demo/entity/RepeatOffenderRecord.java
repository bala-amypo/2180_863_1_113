package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RepeatOffenderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;

    public Long getId() { return id; }
    public int getCount() { return count; }

    public void setId(Long id) { this.id = id; }
    public void setCount(int count) { this.count = count; }
}
