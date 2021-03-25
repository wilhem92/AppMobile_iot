package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.*;

public class LampeActivity extends AppCompatActivity {

    private Button StartButton;     // Bouton Allumer
    private Button StopButton;      // Bouton éteindre
    private ImageView v;
    private ImageView retour_accueil2;
    private ImageView retour_choix1;

    public LampeActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lampe);
        StartButton = (Button) findViewById(R.id.activity_main_buttonStart2);
        StopButton = (Button) findViewById(R.id.activity_main_buttonStop2);
        this.retour_accueil2 = (ImageView) findViewById(R.id.retour_accueil2);
        this.retour_choix1 = (ImageView) findViewById(R.id.retour_choix1);

        // Gestion bouton Allumer
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",1,"on")).start();
            }
        });

        // Gestion bouton Eteindre
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",1,"off")).start();
            }
        });

        // Gestion bouton Retour Accueil
        retour_accueil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourAccueil2 = new Intent(getApplicationContext(), AccueilActivity.class);
                startActivity(retourAccueil2);
                finish();
            }
        });

        // Gestion bouton Retour choix
        retour_choix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourChoix1 = new Intent(getApplicationContext(), DevicesActivity.class);
                startActivity(retourChoix1);
                finish();
            }
        });


    }
}