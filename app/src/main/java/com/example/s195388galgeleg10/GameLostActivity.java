package com.example.s195388galgeleg10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLostActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik logik = new Galgelogik();
    Button backToMenu, tryAgain;
    TextView textViewTheRightWord2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelost);

        //Find view by id

        backToMenu = findViewById(R.id.backToMenu);
        tryAgain = findViewById(R.id.tryAgain);
        textViewTheRightWord2 = findViewById(R.id.textViewTheRightWord2);

        textViewTheRightWord2.setText("Ordet var: " + getIntent().getExtras().getString("word"));


        //On click

        backToMenu.setOnClickListener(this);
        tryAgain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == tryAgain) {
            Intent i = new Intent(this, GameQuickStartActivity.class);
            startActivity(i);
        } else if (v == backToMenu) {
            Intent i = new Intent(this, GameWelcomeActivity.class);
            startActivity(i);

        }
    }
}