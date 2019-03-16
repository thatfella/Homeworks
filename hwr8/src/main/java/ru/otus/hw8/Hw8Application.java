package ru.otus.hw8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class Hw8Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw8Application.class, args);
	}

}
