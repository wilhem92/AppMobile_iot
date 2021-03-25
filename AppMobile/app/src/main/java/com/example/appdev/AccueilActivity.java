package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// Ecran d'accueil après s'être authentifié
public class AccueilActivity extends AppCompatActivity {

    private Button commencer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    // Bouton commencer
        this.commencer = (Button) findViewById(R.id.commencer);

        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choixActivity = new Intent(getApplicationContext(), DevicesActivity.class);
                startActivity(choixActivity);
                finish();
            }
        });
    }
}