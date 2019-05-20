package ru.otus.hw12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

@EnableMongoRepositories
@SpringBootApplication
public class Hw12Application {

    public static void main(String[] args) {

        SpringApplication.run(Hw12Application.class, args);
    }

}
