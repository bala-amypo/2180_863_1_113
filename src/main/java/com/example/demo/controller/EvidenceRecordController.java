package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;

@RestController
@RequestMapping("/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService service;

    public EvidenceRecordController(EvidenceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public EvidenceRecord save(@RequestBody EvidenceRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<EvidenceRecord> getAll() {
        return service.getAll();
    }
}
