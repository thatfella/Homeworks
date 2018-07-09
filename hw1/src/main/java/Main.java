import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.hw1.service.ParserService;
import ru.otus.hw1.service.StudentService;
import ru.otus.hw1.service.TestChecker;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentService studentService = context.getBean(StudentService.class);
        ParserService parser = context.getBean(ParserService.class);
        TestChecker checker = context.getBean(TestChecker.class);

        System.out.println("Enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        studentService.getStudModel().setName(name);
        System.out.println(studentService.greetStudent());
        parser.getTestQuestions(parser.getFileDirection());
        int[] studAnswers = checker.getStudentAnswers();
        checker.checkStudent(studAnswers);
    }
}
