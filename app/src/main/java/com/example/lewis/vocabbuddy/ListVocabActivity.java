package com.example.lewis.vocabbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
        vocabTextView = (TextView) findViewById(R.id.vocab_textview);
        vocabTextView.setText(spokenWords);
    }
}
