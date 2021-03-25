package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TVActivity extends AppCompatActivity {

    private ImageView retour_accueil4;
    private ImageView retour_choix3;
    private Button StartButton;     // Bouton Allumer
    private Button StopButton;      // Bouton éteindre

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        StartButton = (Button) findViewById(R.id.activity_main_buttonStart4);
        StopButton = (Button) findViewById(R.id.activity_main_buttonStop4);

        this.retour_accueil4 = (ImageView) findViewById(R.id.retour_accueil4);

        retour_accueil4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourAccueil4 = new Intent(getApplicationContext(), AccueilActivity.class);
                startActivity(retourAccueil4);
                finish();
            }
        });

        this.retour_choix3 = (ImageView) findViewById(R.id.retour_choix3);

        retour_choix3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourChoix3 = new Intent(getApplicationContext(), DevicesActivity.class);
                startActivity(retourChoix3);
                finish();
            }
        });

        // Gestion bouton Allumer
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",3,"on")).start();
            }
        });

        // Gestion bouton Eteindre
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",3,"off")).start();
            }
        });
    }
}