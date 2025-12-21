package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EvidenceRecord;

public interface EvidenceRecordService {
    EvidenceRecord save(EvidenceRecord record);
    List<EvidenceRecord> getAll();
}
