package ru.otus.hmwrk11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.hmwrk11.dao.AuthorRepo;
import ru.otus.hmwrk11.model.Author;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Hmwrk11Application {

	@Autowired
	private AuthorRepo authorRepo;

	public static void main(String[] args) {
		SpringApplication.run(Hmwrk11Application.class, args);
	}

	@PostConstruct
	public  void prepopulateAuthors() {
		authorRepo.save(new Author(1, "Remarque")).subscribe();
		authorRepo.save(new Author(2, "Lafore")).subscribe();
	}

}
