package ru.otus.hw1.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.otus.hw1.model.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserService {

    private String fileDirection;

    private Test testmodel;

    public void getTestQuestions(String fileDirection) throws IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(new FileReader(fileDirection), format);

        List<Test> questions = new ArrayList<Test>();
        for (CSVRecord record : parser) {
            Test test = new Test();
            test.setId(record.get("ID"));
            test.setQuestion(record.get("Question"));
            test.setFirstAnswer(record.get("firstAnswer"));
            test.setSecondAnswer(record.get("secondAnswer"));
            questions.add(test);
        }
        //close the parser
        parser.close();

        System.out.println(questions);
    }

    public String getFileDirection() {
        return fileDirection;
    }

    public void setFileDirection(String fileDirection) {
        this.fileDirection = fileDirection;
    }

    public Test getTestmodel() {
        return testmodel;
    }

    public void setTestmodel(Test testmodel) {
        this.testmodel = testmodel;
    }
}
