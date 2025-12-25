package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtProvider;

    public AuthServiceImpl(AppUserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder,
                           AuthenticationManager authManager, JwtTokenProvider jwtProvider) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegisterRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email exists");
        }
        AppUser user = new AppUser(req.getFullName(), req.getEmail(), encoder.encode(req.getPassword()));
        roleRepo.findByName(req.getRole()).ifPresent(r -> user.getRoles().add(r));
        userRepo.save(user);
    }

    @Override
    public JwtResponse login(LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        
        AppUser user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        String role = user.getRoles().isEmpty() ? "" : user.getRoles().iterator().next().getName();
        String token = jwtProvider.generateToken(auth, user.getId(), user.getEmail(), role);
        
        return new JwtResponse(token, user.getEmail(), role);
    }
}