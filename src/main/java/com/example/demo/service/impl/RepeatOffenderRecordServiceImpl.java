package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.RepeatOffenderRecordService;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {
    public RepeatOffenderRecordServiceImpl(StudentProfileRepository spr, IntegrityCaseRepository icr,
                                           RepeatOffenderRecordRepository rorr, RepeatOffenderCalculator roc) {
        // Constructor matching test instantiation
    }
}