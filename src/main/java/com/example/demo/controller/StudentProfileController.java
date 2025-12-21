package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {
    
    private final StudentProfileService studentProfileService;
    
    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }
    
    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile studentProfile) {
        StudentProfile created = studentProfileService.createStudent(studentProfile);
        return ResponseEntity.ok(created);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudent(@PathVariable Long id) {
        StudentProfile student = studentProfileService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    
    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        List<StudentProfile> students = studentProfileService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    @PutMapping("/{id}/repeat-status")
    public ResponseEntity<StudentProfile> updateRepeatStatus(@PathVariable Long id) {
        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(id);
        return ResponseEntity.ok(updated);
    }
}