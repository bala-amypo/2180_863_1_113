package com.example.demo.config;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            RoleRepository roleRepository,
            UserRepository userRepository,
            StudentProfileRepository studentProfileRepository,
            IntegrityCaseRepository integrityCaseRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            /* ================= ROLES ================= */
            if (roleRepository.count() == 0) {
                roleRepository.saveAll(List.of(
                        new Role(null, "ADMIN"),
                        new Role(null, "FACULTY"),
                        new Role(null, "REVIEWER"),
                        new Role(null, "STUDENT")
                ));
            }

            Role adminRole = roleRepository.findByName("ADMIN").get();
            Role facultyRole = roleRepository.findByName("FACULTY").get();

            /* ================= USERS ================= */
            if (userRepository.count() == 0) {

                AppUser admin = new AppUser();
                admin.setFullName("System Admin");
                admin.setEmail("admin@demo.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setEnabled(true);
                admin.setRoles(Set.of(adminRole));

                AppUser faculty = new AppUser();
                faculty.setFullName("Faculty User");
                faculty.setEmail("faculty@demo.com");
                faculty.setPassword(passwordEncoder.encode("faculty123"));
                faculty.setEnabled(true);
                faculty.setRoles(Set.of(facultyRole));

                userRepository.saveAll(List.of(admin, faculty));
            }

            /* ================= STUDENTS ================= */
            if (studentProfileRepository.count() == 0) {

                StudentProfile s1 = new StudentProfile();
                s1.setStudentId("STU2023001");
                s1.setName("Arjun Kumar");
                s1.setEmail("arjun@university.edu");
                s1.setProgram("B.Tech Computer Science");
                s1.setYearLevel(3);
                s1.setRepeatOffender(false);

                StudentProfile s2 = new StudentProfile();
                s2.setStudentId("STU2023002");
                s2.setName("Meera Nair");
                s2.setEmail("meera@university.edu");
                s2.setProgram("B.Sc Mathematics");
                s2.setYearLevel(2);
                s2.setRepeatOffender(false);

                studentProfileRepository.saveAll(List.of(s1, s2));
            }

            /* ================= INTEGRITY CASES ================= */
            if (integrityCaseRepository.count() == 0) {

                StudentProfile student = studentProfileRepository.findAll().get(0);

                IntegrityCase c1 = new IntegrityCase();
                c1.setStudentProfile(student);
                c1.setCourseCode("CS301");
                c1.setInstructorName("Dr. Rao");
                c1.setDescription("Plagiarism detected in assignment");
                c1.setStatus("OPEN");
                c1.setIncidentDate(LocalDate.now().minusDays(10));

                IntegrityCase c2 = new IntegrityCase();
                c2.setStudentProfile(student);
                c2.setCourseCode("CS305");
                c2.setInstructorName("Dr. Sharma");
                c2.setDescription("Unauthorized material used in exam");
                c2.setStatus("UNDER_REVIEW");
                c2.setIncidentDate(LocalDate.now().minusDays(3));

                integrityCaseRepository.saveAll(List.of(c1, c2));
            }

            System.out.println("✅ DataInitializer loaded sample data successfully");
        };
    }
}
