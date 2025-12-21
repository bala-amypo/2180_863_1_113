package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    public String login(String username, String password) {
        return "token-" + username;
    }
}
