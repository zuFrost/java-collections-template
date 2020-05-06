package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
                return getWords(text).stream()
                .map((String word) -> word.length())
                .reduce((n, m) -> n + m).get();
    }

    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return getWords(text).stream()
                .collect(Collectors.toSet()).size();
    }

    @Override
    public List<String> getWords(String text) {

        return Arrays.stream(text.split("\\W+"))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {

        return Arrays.stream(text.split("\\W+"))
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return  getWords(text).stream().collect(Collectors.toConcurrentMap(word -> word, count -> 1, Integer::sum));

    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return emptyList();
    }
}
