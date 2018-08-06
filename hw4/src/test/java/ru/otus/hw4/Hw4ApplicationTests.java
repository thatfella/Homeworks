package ru.otus.hw4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw4.model.Student;
import ru.otus.hw4.services.TestChecker;
import ru.otus.hw4.services.YamlService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hw4ApplicationTests {

    @Autowired
    Student student;
    @Autowired
    TestChecker testChecker;
    @Autowired
    YamlService yamlService;
    private static final int[] perfect = {1, 2, 1, 1, 2};

    @Test
    public void contextLoads() {
    }

    @Test
    public void checkStudentNameOK() {
        student.setName("Mock");
        Assert.assertNotNull(student.getName());
    }


    @Test
    public void isperfectTest() {
        Assert.assertArrayEquals(perfect, testChecker.getStudentAnswers());

    }

}
