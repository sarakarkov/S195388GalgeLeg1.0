package com.example.s195388galgeleg10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameWelcomeActivity extends AppCompatActivity implements OnClickListener {

    Button QuickStart, HighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamewelcome);

        //Find view fra Id
        QuickStart = findViewById(R.id.QuickStart);
        HighScore = findViewById(R.id.HighScore);

        // On Click Listener
        QuickStart.setOnClickListener(this);
        HighScore.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v == QuickStart){
            Intent i = new Intent(this, GameQuickStartActivity.class);
            startActivity(i);
        }
        else if (v == HighScore){
            Intent i = new Intent(this, HighScoreActivity.class);
            startActivity(i);
        }
    }
}