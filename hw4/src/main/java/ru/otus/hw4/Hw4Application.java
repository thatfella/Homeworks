package ru.otus.hw4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.Bootstrap;
import ru.otus.hw4.services.LocalizationCommands;

import java.io.IOException;

@ComponentScan("ru.otus")
@SpringBootApplication
public class Hw4Application {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Hw4Application.class, args);
        LocalizationCommands localizationCommands = context.getBean(LocalizationCommands.class);
        Bootstrap.main(args);

    }
}
