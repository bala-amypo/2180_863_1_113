package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository integrityCaseRepository;
    private final StudentProfileRepository studentProfileRepository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository integrityCaseRepository,
                                    StudentProfileRepository studentProfileRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {

        if (integrityCase.getStudentProfile() == null ||
            integrityCase.getStudentProfile().getId() == null) {
            throw new IllegalArgumentException("StudentProfile is required");
        }

        StudentProfile studentProfile = studentProfileRepository
                .findById(integrityCase.getStudentProfile().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "StudentProfile not found with id: "
                                        + integrityCase.getStudentProfile().getId()
                        ));

        integrityCase.setStudentProfile(studentProfile);
        integrityCase.setStatus("OPEN");

        return integrityCaseRepository.save(integrityCase);
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {

        IntegrityCase integrityCase = integrityCaseRepository
                .findById(caseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "IntegrityCase not found with id: " + caseId
                        ));

        integrityCase.setStatus(status);
        return integrityCaseRepository.save(integrityCase);
    }

    @Override
    public List<IntegrityCase> getCasesByStudent(Long studentId) {

        if (!studentProfileRepository.existsById(studentId)) {
            throw new ResourceNotFoundException(
                    "StudentProfile not found with id: " + studentId
            );
        }

        return integrityCaseRepository.findByStudentProfile_Id(studentId);
    }

    @Override
    public Optional<IntegrityCase> getCaseById(Long caseId) {
        return integrityCaseRepository.findById(caseId);
    }
}
