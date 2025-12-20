package ma.formation.msa.userservice.security;

import ma.formation.msa.userservice.model.Role;
import ma.formation.msa.userservice.model.User;
import ma.formation.msa.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository,
                                PasswordEncoder passwordEncoder) {

        return args -> {

            // ===== ADMIN =====
            if (userRepository.findByEmail("admin@emsi.ma").isEmpty()) {

                User admin = new User();
                admin.setEmail("admin@emsi.ma");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setRole(Role.ADMIN);
                admin.setFullName("ADMIN EMSI");

                userRepository.save(admin);
            }

            // ===== STUDENT =====
            if (userRepository.findByEmail("student@emsi.ma").isEmpty()) {

                User student = new User();
                student.setEmail("student@emsi.ma");
                student.setPassword(passwordEncoder.encode("123456"));
                student.setRole(Role.STUDENT);
                student.setFullName("STUDENT EMSI");

                userRepository.save(student);
            }
        };
    }
}
