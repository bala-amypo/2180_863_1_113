package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RepeatOffenderRecord save(RepeatOffenderRecord record) {
        return repository.save(record);
    }

    @Override
    public List<RepeatOffenderRecord> getAll() {
        return repository.findAll();
    }
}
