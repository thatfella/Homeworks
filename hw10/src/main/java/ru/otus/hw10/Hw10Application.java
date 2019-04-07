package ru.otus.hw10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.hw10.service.AuthorService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Hw10Application {
	private AuthorService authorService;

	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Hw10Application.class, args);
	}

	@PostConstruct
	public  void prepopulateAuthors() {
		authorService.saveAuthor(1, "Remarque");
		authorService.saveAuthor(2, "Lafore");
	}
}
