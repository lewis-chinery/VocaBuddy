package com.example.lewis.vocabbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button recordButton;
    TextView recordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordButton = (Button) findViewById(R.id.record_button);
        recordTextView = (TextView) findViewById(R.id.record_textview);
    }

    public void changeText(View view) {
        recordTextView.setText("Record button pressed successfully");
    }
}
