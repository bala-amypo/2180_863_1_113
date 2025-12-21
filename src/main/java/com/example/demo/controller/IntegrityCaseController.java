package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

@RestController
@RequestMapping("/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService service;

    public IntegrityCaseController(IntegrityCaseService service) {
        this.service = service;
    }

    @PostMapping
    public IntegrityCase save(@RequestBody IntegrityCase integrityCase) {
        return service.save(integrityCase);
    }

    @GetMapping
    public List<IntegrityCase> getAll() {
        return service.getAll();
    }
}
