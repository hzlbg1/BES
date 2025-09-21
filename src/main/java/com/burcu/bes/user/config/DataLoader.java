package com.burcu.bes.user.config;

import com.burcu.bes.user.model.User;
import com.burcu.bes.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(User.builder()
                        .firstName("Ali")
                        .lastName("Yılmaz")
                        .email("ali@example.com")
                        .password("sifre456")
                        .build());
                userRepository.save(User.builder()
                        .firstName("Veli")
                        .lastName("Şahin")
                        .email("veli@example.com")
                        .password("sifre123")
                        .build());
            }
        };
    }
}
