package com.example.s195388galgeleg10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class GameQuickStartActivity extends AppCompatActivity implements OnClickListener {

    Galgelogik logik = new Galgelogik();
    private ImageView galge;
    private TextView ForkerteBogstaver;
    private TextView Ordet;
    private Button guessButton;
    private EditText GuessWord;

    List<Integer> image = new ArrayList<>();

    int antalForsøg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamequickstart);

        antalForsøg = 0;

        logik.startNytSpil();
        try {
            logik.hentOrdFraRegneark("12");
        } catch (Exception e) {
            e.printStackTrace();
        }

        galge = findViewById(R.id.galge);
        ForkerteBogstaver = findViewById(R.id.ForkerteBogstaver);
        Ordet = findViewById(R.id.Ordet);
        guessButton = findViewById(R.id.guessButton);
        GuessWord = findViewById(R.id.GuessWord);

        guessButton.setOnClickListener(this);
        logik.logStatus();

        image.add(R.drawable.galge);
        image.add(R.drawable.forkert1);
        image.add(R.drawable.forkert2);
        image.add(R.drawable.forkert3);
        image.add(R.drawable.forkert4);
        image.add(R.drawable.forkert5);
        image.add(R.drawable.forkert6);

        opdaterSkærm();

    }

    @Override
    public void onClick(View v) {

        String bogstav = GuessWord.getText().toString();
        if (bogstav.length() != 1) {
            GuessWord.setError("Skriv et bogstav");
            GuessWord.setText(null);
            return;
        }
        logik.gætBogstav(bogstav);
        GuessWord.setText(null);
        GuessWord.setError(null);

        opdaterSkærm();

    }

    private void opdaterSkærm() {
        Ordet.setText("Gæt ordet: " + logik.getSynligtOrd());
        ForkerteBogstaver.setText(logik.getAntalForkerteBogstaver() + ": " + logik.getBrugteBogstaver());
        updatePicture();

        if (logik.erSpilletVundet()) {
            Intent i = new Intent(this, GameWonActivity.class);
            i.putExtra("tries", antalForsøg);
            i.putExtra("word", logik.getOrdet());
            startActivity(i);
        }
        if (logik.erSpilletTabt()) {
                Intent i = new Intent(this, GameLostActivity.class);
                i.putExtra("tries", antalForsøg);
                i.putExtra("word", logik.getOrdet());
                startActivity(i);
            }
            antalForsøg++;
    }

    private void updatePicture() {
        if (logik.getAntalForkerteBogstaver() < 7) {
            galge.setImageResource(image.get(logik.getAntalForkerteBogstaver()));
        }
    }
}