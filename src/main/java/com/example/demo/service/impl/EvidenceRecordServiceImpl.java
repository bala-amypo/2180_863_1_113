package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.stereotype.Service;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {
    private final EvidenceRecordRepository repo;
    private final IntegrityCaseRepository caseRepo;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repo, IntegrityCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord e) {
        // Ensure case exists
        caseRepo.findById(e.getIntegrityCase().getId());
        return repo.save(e);
    }
}