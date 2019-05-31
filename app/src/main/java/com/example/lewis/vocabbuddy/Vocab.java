package com.example.lewis.vocabbuddy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class Vocab {

    public static String[] convertTextToArray (String inputText) {
        String[] outputArray = inputText.split(" ");
        return outputArray;
    }

    public static HashMap<String, Integer> populateHashMapWithWords (String[] inputArray) {
        HashMap<String, Integer> HashMapWithZeroValues = new HashMap<String, Integer>();
        for (String word : inputArray) {
            HashMapWithZeroValues.put(word, 0);
        }
        return HashMapWithZeroValues;
    }

    public static HashMap<String, Integer> incrementHashMapValues (HashMap<String, Integer> zeroMap, String[] spokenArray) {
        for (String word : spokenArray) {
            zeroMap.put(word, zeroMap.get(word) + 1);
        }
        return zeroMap;
    }

    public static Map<String, Integer> orderHashMap (HashMap<String, Integer> inputMap) {
        Map<String, Integer> sortedAlphabetically = inputMap
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        Map<String, Integer> sortedValues = sortedAlphabetically
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        return sortedValues;
    }

    public static ArrayList<String> getVocabArray (Map<String, Integer> inputMap) {
        ArrayList<String> outputVocabArray = new ArrayList<String>();
        for (String keyWord: inputMap.keySet()) {
            outputVocabArray.add(keyWord);
        }
        return outputVocabArray;
    }

    public static ArrayList<String> getFreqArray (Map<String, Integer> inputMap) {
        ArrayList<String> outputFreqArray = new ArrayList<String>();
        for (String keyWord: inputMap.keySet()) {
            outputFreqArray.add(String.valueOf(inputMap.get(keyWord)));
        }
        return outputFreqArray;
    }

}
