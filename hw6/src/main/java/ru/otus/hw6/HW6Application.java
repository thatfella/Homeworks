package ru.otus.hw6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.Bootstrap;
import ru.otus.hw6.service.DataBaseCommands;

import java.io.IOException;

@ComponentScan("ru.otus")
@SpringBootApplication
public class HW6Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HW6Application.class, args);
        DataBaseCommands dataBaseCommands = context.getBean(DataBaseCommands.class);
        try {
            Bootstrap.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
