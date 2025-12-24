package com.example.demo.config;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            /* ========= CREATE ROLES ========= */
            if (roleRepository.count() == 0) {

                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("FACULTY"));
                roleRepository.save(new Role("REVIEWER"));
                roleRepository.save(new Role("STUDENT"));
            }

            /* ========= CREATE ADMIN USER ========= */
            if (!userRepository.existsByEmail("admin@demo.com")) {

                Role adminRole = roleRepository.findByName("ADMIN")
                        .orElseThrow(() ->
                                new RuntimeException("ADMIN role not found"));

                AppUser admin = new AppUser();
                admin.setFullName("System Admin");
                admin.setEmail("admin@demo.com");
                admin.setPassword(
                        passwordEncoder.encode("admin123")
                );
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));

                userRepository.save(admin);
            }
        };
    }
}
