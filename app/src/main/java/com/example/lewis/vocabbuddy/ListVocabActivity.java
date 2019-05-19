package com.example.lewis.vocabbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class ListVocabActivity extends AppCompatActivity {

    // Android tutorial for starting another Activity:
    // https://developer.android.com/training/basics/firstapp/starting-activity
    TextView vocabTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vocab);

        Intent startListVocabIntent = getIntent();
        String spokenWords = startListVocabIntent.getStringExtra(MainActivity.EXTRA_SPEECH);

        String[] spokenArray = Vocab.convertTextToArray(spokenWords);
        HashMap<String, Integer> zeroValueSpokenHashMap = Vocab.populateHashMapWithWords(spokenArray);
        HashMap<String, Integer> nonZeroSpokenHashMap = Vocab.incrementHashMapValues(zeroValueSpokenHashMap, spokenArray);

        String mapAsString= "";
        for (String word: nonZeroSpokenHashMap.keySet()) {
            mapAsString += word + " - " + nonZeroSpokenHashMap.get(word) + "\n";
        }

        vocabTextView = (TextView) findViewById(R.id.vocab_textview);
        vocabTextView.setText(mapAsString);
        //vocabTextView.setText(Arrays.toString(spokenArray));
    }
}
