package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evidence")
@Tag(name = "Evidence Records")
public class EvidenceRecordController {
    private final EvidenceRecordService service;

    public EvidenceRecordController(EvidenceRecordService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Submit evidence")
    public ResponseEntity<EvidenceRecord> submitEvidence(@RequestBody EvidenceRecord e) {
        return ResponseEntity.ok(service.submitEvidence(e));
    }
}