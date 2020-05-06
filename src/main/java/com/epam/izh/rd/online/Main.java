package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.Direction;
import com.epam.izh.rd.online.helper.FileReaderService;
import com.epam.izh.rd.online.service.SimpleTextStatisticsAnalyzer;
import com.epam.izh.rd.online.service.StreamApiTextStatisticsAnalyzer;

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
        StreamApiTextStatisticsAnalyzer streamApiTextStatisticsAnalyzer = new StreamApiTextStatisticsAnalyzer();

//        System.out.println("количество слов в тексте = " + listOfWordsInText.size());
//        System.out.println(listOfWordsInText);
//
//        System.out.println("количество уникальных слов в тексте = " + simpleTextStatisticsAnalyzer.getUniqueWords(textForManipulation).size());
//        System.out.println(simpleTextStatisticsAnalyzer.getUniqueWords(textForManipulation));
//
//        System.out.println("количество уникальных слов Map = " + simpleTextStatisticsAnalyzer.countNumberOfWordsRepetitions(textForManipulation).size());
//        System.out.println(simpleTextStatisticsAnalyzer.countNumberOfWordsRepetitions(textForManipulation));
//
//        System.out.println("sortWordsByLength ASC " + simpleTextStatisticsAnalyzer.sortWordsByLength(textForManipulation, Direction.ASC));
//        System.out.println("sortWordsByLength DESC " + simpleTextStatisticsAnalyzer.sortWordsByLength(textForManipulation, Direction.DESC));
//
//        System.out.println("countSumLengthOfWords = " + simpleTextStatisticsAnalyzer.countSumLengthOfWords(textForManipulation));
//        System.out.println("countNumberOfWords = " + simpleTextStatisticsAnalyzer.countNumberOfWords(textForManipulation));
//        System.out.println("getUniqueWords = " + simpleTextStatisticsAnalyzer.countNumberOfUniqueWords(textForManipulation));
        //* Например для текста "Hello, Hi, mother, father - good, cat, c!!" должны вернуться результаты :
        //     * ASC : {"mother", "father", "Hello", "good", "cat", "Hi", "c"}
        //     * DESC : {"c", "Hi", "cat", "good", "Hello", "father", "mother"}
//        String testString = "Hello, Hi, mother, father - good, cat, c!!";
//        System.out.println("sortWordsByLength = " + simpleTextStatisticsAnalyzer.sortWordsByLength(testString, Direction.DESC));
//        System.out.println(streamApiTextStatisticsAnalyzer.getWords(textForManipulation));
//        System.out.println(streamApiTextStatisticsAnalyzer.getUniqueWords(textForManipulation));
        System.out.println("countNumberOfWords " + streamApiTextStatisticsAnalyzer.countNumberOfWords(textForManipulation));
        System.out.println("countSumLengthOfWords " + streamApiTextStatisticsAnalyzer.countSumLengthOfWords(textForManipulation));




    }
}
