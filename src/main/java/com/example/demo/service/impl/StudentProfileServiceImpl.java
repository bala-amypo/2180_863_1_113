package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    
    private final StudentProfileRepository studentProfileRepository;
    
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }
    
    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        studentProfile.setCreatedAt(LocalDateTime.now());
        return studentProfileRepository.save(studentProfile);
    }
    
    @Override
    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
    
    @Override
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }
    
    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);
        // Simple logic: if more than 1 case, mark as repeat offender
        student.setRepeatOffender(student.getIntegrityCases().size() > 1);
        return studentProfileRepository.save(student);
    }
}