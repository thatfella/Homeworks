package com.example.hw3;

import com.example.hw3.services.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hw3ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    ParserService parserService;


    @Test
    public void checkFileDir() {
        Assert.isTrue(parserService.getYamlService().getFilesPath().equals("E:/otus/hw3/src/main/resources/questions.csv"), "must be not null");
    }


}
