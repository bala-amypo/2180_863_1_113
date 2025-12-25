package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RepeatOffenderCalculator {
    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        int count = cases.size();
        record.setTotalCases(count);

        if (count >= 4) {
            record.setFlagSeverity("HIGH");
        } else if (count >= 2) {
            record.setFlagSeverity("MEDIUM");
        } else if (count >= 1) {
            record.setFlagSeverity("LOW");
        } else {
            record.setFlagSeverity("NONE");
        }
        return record;
    }
}