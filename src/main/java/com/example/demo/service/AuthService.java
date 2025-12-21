package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    void register(String email, String password, String fullName, String roleName);
}