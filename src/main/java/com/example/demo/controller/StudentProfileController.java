package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profile")
public class StudentProfileController {
    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create student")
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile student) {
        return ResponseEntity.ok(service.createStudent(student));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PutMapping("/{id}/repeat-offender")
    @Operation(summary = "Update repeat offender status")
    public ResponseEntity<StudentProfile> updateRepeatOffenderStatus(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateRepeatOffenderStatus(id));
    }
}