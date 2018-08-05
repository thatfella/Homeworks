package com.example.hw3.services;


import com.example.hw3.model.Test;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component

public class ParserService {


    public YamlService getYamlService() {
        return yamlService;
    }

    public void setYamlService(YamlService yamlService) {
        this.yamlService = yamlService;
    }

    @Autowired
    private YamlService yamlService;

    private Test testmodel;

    public void getTestQuestions() throws IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(new FileReader(yamlService.getFilesPath()), format);

        List<Test> questions = new ArrayList<Test>();
        for (CSVRecord record : parser) {
            Test test = new Test();
            test.setId(record.get("ID"));
            test.setQuestion(record.get("Question"));
            test.setFirstAnswer(record.get("firstAnswer"));
            test.setSecondAnswer(record.get("secondAnswer"));
            questions.add(test);
        }
        parser.close();

        System.out.println(questions);
    }

    public Test getTestmodel() {
        return testmodel;
    }

    public void setTestmodel(Test testmodel) {
        this.testmodel = testmodel;
    }



}
