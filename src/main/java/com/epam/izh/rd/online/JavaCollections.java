package com.epam.izh.rd.online;


import com.epam.izh.rd.online.service.CheckResultsService;
import com.epam.izh.rd.online.service.Direction;
import com.epam.izh.rd.online.service.FileReaderService;
import com.epam.izh.rd.online.service.TextStatisticsAnalyzer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * В данном классе проверяется корректность реализованных вами методов.
 * Текст для проверки уже задан.
 *
 * Результаты работы методов будут проверены с ответами.
 * Если метод реализован неверно, в консоль будет выведена ошибка.
 */
public class JavaCollections {

    public static void main(String[] args) throws IOException, URISyntaxException {

        /* Загрузка текста */
        FileReaderService fileReaderService = new FileReaderService();
        String sampleText = fileReaderService.readFromFileToString("sample-text.txt");

        Properties textWordsStatisticProperties = fileReaderService.loadProperties("text-words-statistics.properties");
        Properties wordsRepetitionsStatisticProperties = fileReaderService.loadProperties("words-statistics.properties");

        Integer correctNumberOfWords = Integer.valueOf(textWordsStatisticProperties.getProperty("number.of.words"));
        Integer correctNumberOfUniqueWords = Integer
                .valueOf(textWordsStatisticProperties.getProperty("number.of.unique.words"));
        Integer correctSumLengthOfWords = Integer
                .valueOf(textWordsStatisticProperties.getProperty("sum.length.of.words"));

        boolean practiseMadeCorrectly;
        CheckResultsService checkResultsService = new CheckResultsService();

        TextStatisticsAnalyzer textStatisticsAnalyzer = new TextStatisticsAnalyzer();

        // --------------------------- countSumLengthOfWords --------------------------- //

        Integer sumLengthOfWords = textStatisticsAnalyzer.countSumLengthOfWords(sampleText);
        practiseMadeCorrectly = checkResultsService.countSumLengthOfWords(sumLengthOfWords, correctSumLengthOfWords);

        // --------------------------- countNumberOfWords --------------------------- //

        Integer numberOfWords = textStatisticsAnalyzer.countNumberOfWords(sampleText);
        practiseMadeCorrectly = checkResultsService
                .checkCountNumberOfWordsMethod(numberOfWords, correctNumberOfWords) && practiseMadeCorrectly;

        // --------------------------- countNumberOfUniqueWords --------------------------- //

        Integer numberOfUniqueWords = textStatisticsAnalyzer.countNumberOfUniqueWords(sampleText);
        practiseMadeCorrectly = checkResultsService
                .checkCheckCountNumberOfUniqueWordsMethod(numberOfUniqueWords,
                        correctNumberOfUniqueWords) && practiseMadeCorrectly;

        // --------------------------- getWords --------------------------- //

        List<String> foundWords = textStatisticsAnalyzer.getWords(sampleText);
        practiseMadeCorrectly = checkResultsService
                .checkGetWordsMethod(foundWords, correctNumberOfWords,
                        wordsRepetitionsStatisticProperties) && practiseMadeCorrectly;

        // --------------------------- getUniqueWords --------------------------- //

        Set<String> foundUniqueWords = textStatisticsAnalyzer.getUniqueWords(sampleText);
        practiseMadeCorrectly = checkResultsService
                .checkGetUniqueWordsMethod(foundUniqueWords, correctNumberOfUniqueWords,
                        wordsRepetitionsStatisticProperties) && practiseMadeCorrectly;

        // --------------------------- countNumberOfWordsRepetitions --------------------------- //

        Map<String, Integer> numberOfWordsRepetitions = textStatisticsAnalyzer
                .countNumberOfWordsRepetitions(sampleText);
        practiseMadeCorrectly = checkResultsService
                .checkCountNumberOfWordsRepetitionsMethod(numberOfWordsRepetitions, correctNumberOfUniqueWords,
                        wordsRepetitionsStatisticProperties) && practiseMadeCorrectly;

        // --------------------------- sortWordsByLength ASC --------------------------- //

        List<String> ascSortedWords = textStatisticsAnalyzer.sortWordsByLength(sampleText, Direction.ASC);
        practiseMadeCorrectly = checkResultsService
                .checkSortWordsByLengthMethodAsc(ascSortedWords, correctNumberOfWords) && practiseMadeCorrectly;

        // --------------------------- sortWordsByLength DESC --------------------------- //

        List<String> descSortedWords = textStatisticsAnalyzer.sortWordsByLength(sampleText, Direction.DESC);
        practiseMadeCorrectly = checkResultsService
                .checkSortWordsByLengthMethodDesc(descSortedWords, correctNumberOfWords) && practiseMadeCorrectly;

        if (practiseMadeCorrectly) {
            System.out.println("Практика сделана верно");
        } else {
            System.out.println("Практика сделана неверно");
        }
    }

}
