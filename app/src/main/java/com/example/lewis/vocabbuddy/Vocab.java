package com.example.lewis.vocabbuddy;

import java.util.HashMap;

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

    public HashMap<String, Integer> incrementHashMapValues (HashMap<String, Integer> zeroMap, String[] spokenArray) {
        for (String word : spokenArray) {
            zeroMap.put(word, zeroMap.get(word) + 1);
        }
        return zeroMap;
    }

}
