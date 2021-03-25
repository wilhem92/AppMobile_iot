package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CafeActivity extends AppCompatActivity {

    private ImageView retour_accueil3;
    private ImageView retour_choix2;
    private Button StartButton;
    private Button StopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        StartButton = (Button) findViewById(R.id.activity_main_buttonStart3);
        StopButton = (Button) findViewById(R.id.activity_main_buttonStop3);

        this.retour_accueil3 = (ImageView) findViewById(R.id.retour_accueil3);

        retour_accueil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourAccueil3 = new Intent(getApplicationContext(), AccueilActivity.class);
                startActivity(retourAccueil3);
                finish();
            }
        });

        this.retour_choix2 = (ImageView) findViewById(R.id.retour_choix2);

        retour_choix2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourChoix2 = new Intent(getApplicationContext(), DevicesActivity.class);
                startActivity(retourChoix2);
                finish();
            }
        });

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",2,"on")).start();
            }
        });

        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new PiloteDevice("192.168.0.189",2,"off")).start();
            }
        });
    }
}