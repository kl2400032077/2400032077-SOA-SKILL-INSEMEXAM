package com.example.banking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.banking.entity.User;
import com.example.banking.repository.UserRepository;

@SpringBootApplication
public class BankingserviceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingserviceAuthApplication.class, args);
    }

    @Bean
    CommandLineRunner createTestUser(UserRepository repository) {
        return args -> {
            if (repository.findByUsername("customer1").isEmpty()) {
                BCryptPasswordEncoder encoder =
                        new BCryptPasswordEncoder();

                repository.save(new User(
                        "customer1",
                        encoder.encode("Bank@123")));
            }
        };
    }
}