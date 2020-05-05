package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.FileReaderService;
import com.epam.izh.rd.online.service.SimpleTextStatisticsAnalyzer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        FileReaderService fileReaderService = new FileReaderService();
        String textForManipulation = fileReaderService.readFromFileToString("sample-text.txt");
//        System.out.println(textForManipulation);
        SimpleTextStatisticsAnalyzer simpleTextStatisticsAnalyzer = new SimpleTextStatisticsAnalyzer();
        List<String> listOfWordsInText = new ArrayList<>();
        listOfWordsInText = simpleTextStatisticsAnalyzer.getWords(textForManipulation);

        System.out.println("количество слов в тексте = " + listOfWordsInText.size());
        System.out.println(listOfWordsInText);




    }
}
