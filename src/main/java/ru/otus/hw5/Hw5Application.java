package ru.otus.hw5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.Bootstrap;
import ru.otus.hw5.service.DataBaseCommands;

import java.io.IOException;

@ComponentScan("ru.otus")
@SpringBootApplication
public class Hw5Application {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Hw5Application.class, args);
        DataBaseCommands dataBaseCommands = context.getBean(DataBaseCommands.class);
        try {
            Bootstrap.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
