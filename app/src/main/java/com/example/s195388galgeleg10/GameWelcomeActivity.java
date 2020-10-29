package com.example.s195388galgeleg10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameWelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonQuickStart, buttonHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamewelcome);

        //Find view fra Id

        buttonQuickStart = findViewById(R.id.buttonQuickStart);
        buttonHighScore = findViewById(R.id.buttonHighScore);

        // On Click Listener
        buttonQuickStart.setOnClickListener(this);
        buttonHighScore.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v == buttonQuickStart) {
            Intent i = new Intent(this, GameQuickStartActivity.class);
            startActivity(i);
        } else if (v == buttonHighScore) {
            Intent i = new Intent(this, GameHighScoreActivity.class);
            startActivity(i);

        }
    }
}