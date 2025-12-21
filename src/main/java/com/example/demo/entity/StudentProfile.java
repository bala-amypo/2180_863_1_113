package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String department;

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setDepartment(String department) { this.department = department; }
}
