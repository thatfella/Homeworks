package com.example.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.example")
@SpringBootApplication
public class Hw3Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Hw3Application.class, args);
		AppBean launch = context.getBean(AppBean.class);
		launch.execute();
	}

}
