package ru.otus.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw2.config.AppConfig;

import java.io.IOException;

@Configuration
@ComponentScan (basePackages = "ru.otus")
public class Main {


    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppBean appBean = context.getBean(AppBean.class);
        appBean.launch();

    }
}
