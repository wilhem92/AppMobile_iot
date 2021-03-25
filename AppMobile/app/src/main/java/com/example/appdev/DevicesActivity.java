package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class DevicesActivity extends AppCompatActivity {

    private Button choix_app1, choix_app2,choix_app3, deconnexion;
    private ImageView retour_accueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        this.choix_app1 = (Button) findViewById(R.id.choix_app1);

        choix_app1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choix_app1 = new Intent(getApplicationContext(), LampeActivity.class);
                startActivity(choix_app1);
                finish();
            }
        });

        this.choix_app2 = (Button) findViewById(R.id.choix_app2);

        choix_app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choix_app2 = new Intent(getApplicationContext(), CafeActivity.class);
                startActivity(choix_app2);
                finish();
            }
        });

        this.choix_app3 = (Button) findViewById(R.id.choix_app3);

        choix_app3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choix_app3 = new Intent(getApplicationContext(), TVActivity.class);
                startActivity(choix_app3);
                finish();
            }
        });

        this.retour_accueil = (ImageView) findViewById(R.id.retour_accueil);

        retour_accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourAccueil = new Intent(getApplicationContext(), AccueilActivity.class);
                startActivity(retourAccueil);
                finish();
            }
        });

        this.deconnexion = (Button) findViewById(R.id.button_deconnexion);

        deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });


    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();// déconnexion
        startActivity(new Intent(getApplicationContext(), LoginRegisterActivity.class));
        finish();
    }
}