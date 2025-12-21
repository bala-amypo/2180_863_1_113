package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.service.PenaltyActionService;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository repository;

    public PenaltyActionServiceImpl(PenaltyActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PenaltyAction save(PenaltyAction action) {
        return repository.save(action);
    }

    @Override
    public List<PenaltyAction> getAll() {
        return repository.findAll();
    }
}
