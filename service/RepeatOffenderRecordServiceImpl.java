package com.example.demo.service;

import com.example.demo.repository.*;
import com.example.demo.util.RepeatOffenderCalculator;

public class RepeatOffenderRecordServiceImpl {

    public RepeatOffenderRecordServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository repeatRepo,
            RepeatOffenderCalculator calculator
    ) {}
}
