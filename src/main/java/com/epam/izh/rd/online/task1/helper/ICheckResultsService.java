package com.epam.izh.rd.online.task1.helper;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public interface ICheckResultsService {
    boolean countSumLengthOfWords(Integer sumLengthOfWords, Integer correctSumLengthOfWords);

    boolean checkCountNumberOfWordsMethod(Integer numberOfWords, Integer correctNumberOfWords);

    boolean checkCheckCountNumberOfUniqueWordsMethod(Integer numberOfUniqueWords, Integer correctNumberOfUniqueWords);

    boolean checkGetWordsMethod(List<String> foundWords, Integer correctNumberOfWords,
                                Properties wordsStatisticProperties);

    boolean checkGetUniqueWordsMethod(Set<String> foundUniqueWords, Integer correctNumberOfUniqueWords,
                                      Properties wordsStatisticProperties);

    boolean checkCountNumberOfWordsRepetitionsMethod(Map<String, Integer> numberOfWordsRepetitions,
                                                     Integer correctNumberOfUniqueWords,
                                                     Properties wordsStatisticProperties);

    boolean checkSortWordsByLengthMethodAsc(List<String> ascSortedWords, Integer correctNumberOfWords);

    boolean checkSortWordsByLengthMethodDesc(List<String> descSortedWords, Integer correctNumberOfWords);
}
