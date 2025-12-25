package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
@Tag(name = "Integrity Cases")
public class IntegrityCaseController {
    private final IntegrityCaseService service;

    public IntegrityCaseController(IntegrityCaseService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create integrity case")
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase c) {
        return ResponseEntity.ok(service.createCase(c));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update case status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateCaseStatus(id, status));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get cases by student")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getCasesByStudent(studentId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get case by ID")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return service.getCaseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}