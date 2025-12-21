package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {
    
    private final IntegrityCaseRepository integrityCaseRepository;
    
    public IntegrityCaseServiceImpl(IntegrityCaseRepository integrityCaseRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
    }
    
    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        if (integrityCase.getStudentProfile() == null) {
            throw new IllegalArgumentException("Student profile required");
        }
        integrityCase.setCreatedAt(LocalDateTime.now());
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String newStatus) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(caseId)
            .orElseThrow(() -> new ResourceNotFoundException("Case not found"));
        integrityCase.setStatus(newStatus);
        return integrityCaseRepository.save(integrityCase);
    }
    
    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {
        return integrityCaseRepository.findByStudentProfile_Id(studentId);
    }
    
    @Override
    public Optional<IntegrityCase> getCaseById(Long caseId) {
        return integrityCaseRepository.findById(caseId);
    }
}