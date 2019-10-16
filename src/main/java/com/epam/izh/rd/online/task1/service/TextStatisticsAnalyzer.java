package com.epam.izh.rd.online.task1.service;

import com.epam.izh.rd.online.task1.helper.Direction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TextStatisticsAnalyzer {

    int countSumLengthOfWords(String text);

    int countNumberOfWords(String text);

    int countNumberOfUniqueWords(String text);

    List<String> getWords(String text);

    Set<String> getUniqueWords(String text);

    Map<String, Integer> countNumberOfWordsRepetitions(String text);

    List<String> sortWordsByLength(String text, Direction direction);
}
