package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDate;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile s,
            List<IntegrityCase> cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(s);
        record.setTotalCases(cases.size());

        if (!cases.isEmpty()) {
            record.setLastIncidentDate(
                    cases.get(cases.size() - 1).getIncidentDate()
            );
        }

        if (cases.size() == 1) {
            record.setFlagSeverity("LOW");
        } else if (cases.size() == 2) {
            record.setFlagSeverity("MEDIUM");
        } else if (cases.size() >= 4) {
            record.setFlagSeverity("HIGH");
        }

        return record;
    }
}
