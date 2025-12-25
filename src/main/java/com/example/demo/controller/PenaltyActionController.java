package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
@Tag(name = "Penalty Actions")
public class PenaltyActionController {
    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Add penalty")
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction p) {
        return ResponseEntity.ok(service.addPenalty(p));
    }
}