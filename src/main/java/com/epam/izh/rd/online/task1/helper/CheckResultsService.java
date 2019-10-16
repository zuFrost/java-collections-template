package com.epam.izh.rd.online.task1.helper;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.*;

public class CheckResultsService implements ICheckResultsService {

    @Override
    public boolean countSumLengthOfWords(Integer sumLengthOfWords, Integer correctSumLengthOfWords) {
        if (!sumLengthOfWords.equals(correctSumLengthOfWords)) {
            System.out.println(String.format("Метод countSumLengthOfWords работает неверно. Текущее значение = %s. " +
                    "Ожидаемое значение = %s.", sumLengthOfWords, correctSumLengthOfWords));
            return false;
        }

        return true;
    }

    @Override
    public boolean checkCountNumberOfWordsMethod(Integer numberOfWords, Integer correctNumberOfWords) {
        if (!numberOfWords.equals(correctNumberOfWords)) {
            System.out.println(String.format("Метод countNumberOfWords работает неверно. Текущее значение = %s. " +
                    "Ожидаемое значение = %s.", numberOfWords, correctNumberOfWords));
            return false;
        }

        return true;
    }

    @Override
    public boolean checkCheckCountNumberOfUniqueWordsMethod(Integer numberOfUniqueWords,
                                                            Integer correctNumberOfUniqueWords) {
        if (!numberOfUniqueWords.equals(correctNumberOfUniqueWords)) {
            System.out
                    .println(String.format("Метод countNumberOfUniqueWords работает неверно. Текущее значение = %s. " +
                            "Ожидаемое значение = %s.", numberOfUniqueWords, correctNumberOfUniqueWords));
            return false;
        }

        return true;
    }

    @Override
    public boolean checkGetWordsMethod(List<String> foundWords, Integer correctNumberOfWords,
                                       Properties wordsStatisticProperties) {
        if (!correctNumberOfWords.equals(foundWords.size())) {
            System.out.println(String.format("Метод getWords работает неверно. Количество полученных " +
                    "слов = %s. Ожидаемое количество = %s.", foundWords.size(), correctNumberOfWords));
            return false;
        }

        List<String> notFoundWords = foundWords.stream()
                .filter(word -> wordsStatisticProperties.getProperty(word) == null)
                .collect(Collectors.toList());

        if (!notFoundWords.isEmpty()) {
            System.out.println("Метод getWords работает неверно. Присутствуют лишние слова: ");
            notFoundWords.forEach(System.out::println);
            return false;
        }

        return true;
    }

    @Override
    public boolean checkGetUniqueWordsMethod(Set<String> foundUniqueWords, Integer correctNumberOfUniqueWords,
                                             Properties wordsStatisticProperties) {
        if (!correctNumberOfUniqueWords.equals(foundUniqueWords.size())) {
            System.out
                    .println(String.format("Метод getUniqueWords работает неверно. Количество полученных уникальных " +
                                    "слов = %s. Ожидаемое количество = %s.", foundUniqueWords.size(),
                            correctNumberOfUniqueWords));
            return false;
        }

        List<String> notFoundUniqueWords = foundUniqueWords.stream()
                .filter(word -> wordsStatisticProperties.getProperty(word) == null)
                .collect(Collectors.toList());

        if (!notFoundUniqueWords.isEmpty()) {
            System.out.println("Метод getUniqueWords работает неверно. Присутствуют лишние слова: ");
            notFoundUniqueWords.forEach(System.out::println);
            return false;
        }

        return true;
    }

    @Override
    public boolean checkCountNumberOfWordsRepetitionsMethod(Map<String, Integer> numberOfWordsRepetitions,
                                                            Integer correctNumberOfUniqueWords,
                                                            Properties wordsStatisticProperties) {
        if (!correctNumberOfUniqueWords.equals(numberOfWordsRepetitions.size())) {
            System.out.println(
                    String.format("Метод countNumberOfWordsRepetitions работает неверно. Количество полученных " +
                                    "слов = %s. Ожидаемое количество = %s.", numberOfWordsRepetitions.size(),
                            correctNumberOfUniqueWords));
            return false;
        }

        List<String> wordsWithNotCorrectValues = numberOfWordsRepetitions.entrySet().stream()
                .filter(entry -> {
                    if (wordsStatisticProperties.getProperty(entry.getKey()) == null) {
                        return true;
                    }

                    Integer correctNumberOfWordsRepetitions = valueOf(
                            wordsStatisticProperties.getProperty(entry.getKey()));
                    return !correctNumberOfWordsRepetitions.equals(entry.getValue());
                }).map(Map.Entry::getKey).collect(Collectors.toList());

        if (!wordsWithNotCorrectValues.isEmpty()) {
            System.out
                    .println("Метод countNumberOfWordsRepetitions работает неверно. Количество подсчитанных слов не " +
                            "совпадает для : ");
            wordsWithNotCorrectValues.forEach(System.out::println);
            return false;
        }

        return true;
    }

    @Override
    public boolean checkSortWordsByLengthMethodAsc(List<String> ascSortedWords, Integer correctNumberOfWords) {
        if (!correctNumberOfWords.equals(ascSortedWords.size())) {
            System.out.println(String.format("Метод sortWordsByLength ASC работает неверно. Количество слов в " +
                            "отсортированном списке = %s. Ожидаемое количество слов в отсортированном списке = %s.",
                    ascSortedWords.size(), correctNumberOfWords));
            return false;
        }

        boolean correctSort = true;
        int previousWordLength = MAX_VALUE;

        for (String currentWord : ascSortedWords) {
            int currentWordLength = currentWord.length();
            correctSort = previousWordLength >= currentWordLength;
            previousWordLength = currentWordLength;

            if (!correctSort) {
                break;
            }
        }

        if (!correctSort) {
            System.out.println("Метод sortWordsByLength ASC работает неверно. Некорректная обратная сортировка.");
            ascSortedWords.forEach(System.out::println);
            return false;
        }

        return true;
    }

    @Override
    public boolean checkSortWordsByLengthMethodDesc(List<String> descSortedWords, Integer correctNumberOfWords) {
        if (!correctNumberOfWords.equals(descSortedWords.size())) {
            System.out.println(String.format("Метод sortWordsByLength DESC работает неверно. Количество слов в " +
                            "отсортированном списке = %s. Ожидаемое количество слов в отсортированном списке = %s.",
                    descSortedWords.size(), correctNumberOfWords));
            return false;
        }

        boolean correctSort = true;
        int previousWordLength = MIN_VALUE;

        for (String currentWord : descSortedWords) {
            int currentWordLength = currentWord.length();
            correctSort = previousWordLength <= currentWordLength;
            previousWordLength = currentWordLength;

            if (!correctSort) {
                break;
            }
        }

        if (!correctSort) {
            System.out.println("Метод sortWordsByLength DESC работает неверно. Некорректная прямая сортировка.");
            descSortedWords.forEach(System.out::println);
            return false;
        }

        return true;
    }

}
