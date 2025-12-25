package com.example.demo.service;
import com.example.demo.dto.*;

public interface AuthService {
    void register(RegisterRequest req);
    JwtResponse login(LoginRequest req);
}