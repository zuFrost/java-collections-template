package com.epam.izh.rd.online;

import com.epam.izh.rd.online.helper.Direction;
import com.epam.izh.rd.online.helper.FileReaderService;
import com.epam.izh.rd.online.helper.IFileReaderService;
import com.epam.izh.rd.online.service.SimpleTextStatisticsAnalyzer;
import com.epam.izh.rd.online.service.TextStatisticsAnalyzer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TextAnalyzerTest {

    private static TextStatisticsAnalyzer textStatisticsAnalyzer;

    private static String text;
    private static Properties properties;

    @BeforeAll
    static void setup() {
        IFileReaderService fileReaderService = new FileReaderService();
        textStatisticsAnalyzer = new SimpleTextStatisticsAnalyzer();

        try {
            text = fileReaderService.readFromFileToString("sample-text.txt");
            properties = fileReaderService.loadProperties("words-statistics.properties");
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.countSumLengthOfWords(String text)")
    void testCountSumLengthOfWords() {
        assertEquals(2119, textStatisticsAnalyzer.countSumLengthOfWords(text));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.countNumberOfWords(String text)")
    void testCountNumberOfWords() {
        assertEquals(503, textStatisticsAnalyzer.countNumberOfWords(text));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.countNumberOfUniqueWords(String text)")
    void testCountNumberOfUniqueWords() {
        assertEquals(265, textStatisticsAnalyzer.countNumberOfUniqueWords(text));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.sortWordsByLength(String text, ASC)")
    void testSortWordsByLength() {
        List<String> words = getAllWords().stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        assertEquals(words, textStatisticsAnalyzer.sortWordsByLength(text, Direction.ASC));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.sortWordsByLength(String text, DESC)")
    void testSortWordsByLengthDesc() {
        List<String> words = getAllWords().stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());

        assertEquals(words, textStatisticsAnalyzer.sortWordsByLength(text, Direction.DESC));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.getWords(String text)")
    void testGetWords() {
        assertEquals(getAllWords(), textStatisticsAnalyzer.getWords(text));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.getUniqueWords(String text)")
    void testGetUniqueWords() {
        assertEquals(getAllWords().stream().distinct().collect(Collectors.toList()), textStatisticsAnalyzer.getUniqueWords(text));
    }

    @Test
    @DisplayName("Тест метода TextStatisticsAnalyzer.countNumberOfWordsRepetitions(String text)")
    void testCountNumberOfWordsRepetitions() {
        Map<String, Integer> result = textStatisticsAnalyzer.countNumberOfWordsRepetitions(text);

        for (Map.Entry<String, Integer> e : result.entrySet()) {
            boolean wordMatchWithProperty = Integer.valueOf(properties.getProperty(e.getKey())).equals(e.getValue());

            if (!wordMatchWithProperty) {
                fail();
            }
        }
    }

    private List<String> getAllWords() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            int wordRepetition = Integer.valueOf(entry.getValue().toString());
            String word = entry.getKey().toString();

            if (wordRepetition == 1) {
                result.add(word);
            } else {
                IntStream.rangeClosed(1, wordRepetition).forEach(a -> result.add(word));
            }
        }

        return result;
    }
}
