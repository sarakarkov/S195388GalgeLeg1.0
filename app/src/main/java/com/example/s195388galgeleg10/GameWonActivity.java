package com.example.s195388galgeleg10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameWonActivity extends AppCompatActivity implements View.OnClickListener {

    Button tryAgain, backToMenu, saveHighScore;
    EditText editTextName;
    TextView textViewTheRightWord, textViewHowManyTries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamewon);

        //View by id
        tryAgain = findViewById(R.id.tryAgain);
        backToMenu = findViewById(R.id.backToMenu);
        saveHighScore = findViewById(R.id.saveHighScore);
        editTextName = findViewById(R.id.editTextName);
        textViewTheRightWord = findViewById(R.id.textViewTheRightWord);
        textViewHowManyTries = findViewById(R.id.textViewHowManyTries);

        textViewHowManyTries.setText("Antal forsøg: " + getIntent().getExtras().getInt("antal forsøg"));
        textViewTheRightWord.setText("Ordet var: " + getIntent().getExtras().getString("ordet"));

        // // On Click Listener

        tryAgain.setOnClickListener(this);
        backToMenu.setOnClickListener(this);
        saveHighScore.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == tryAgain) {
            Intent i = new Intent(this, GameQuickStartActivity.class);
            startActivity(i);
        } else if (v == backToMenu) {
            Intent i = new Intent(this, GameWelcomeActivity.class);
            startActivity(i);
        } else if (v == saveHighScore) {
            Intent i = new Intent(this, GameHighScoreActivity.class);
            startActivity(i);
        }
    }
}
