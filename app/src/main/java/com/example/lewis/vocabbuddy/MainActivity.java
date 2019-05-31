package com.example.lewis.vocabbuddy;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView recordTextView;
    public static final int SPEECH_REQUEST = 10;
    public static final String EXTRA_SPEECH = "com.example.lewis.vocabbuddy.SPEECH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordTextView = (TextView) findViewById(R.id.record_textview);
    }

    // Code learned from: https://www.youtube.com/watch?v=0bLwXw5aFOs
    public void getSpeechInput (View view) {
        Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (speechIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(speechIntent, SPEECH_REQUEST);
        } else {
            Toast.makeText(this, "Your device does not support speech input", Toast.LENGTH_SHORT).show();
        }
    }

    // Code learned from: https://www.youtube.com/watch?v=0bLwXw5aFOs
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SPEECH_REQUEST:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String spokenWords = result.get(0);

                    Intent startListVocabIntent = new Intent(this, ListVocabActivity.class);
                    startListVocabIntent.putExtra(EXTRA_SPEECH, spokenWords);
                    startActivity(startListVocabIntent);
                }
                break;
        }
    }
}
