package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.service.EvidenceRecordService;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    private final EvidenceRecordRepository repository;

    public EvidenceRecordServiceImpl(EvidenceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EvidenceRecord save(EvidenceRecord record) {
        return repository.save(record);
    }

    @Override
    public List<EvidenceRecord> getAll() {
        return repository.findAll();
    }
}
