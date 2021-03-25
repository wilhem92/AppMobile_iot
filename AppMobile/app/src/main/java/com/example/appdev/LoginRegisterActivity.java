package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginRegisterActivity extends AppCompatActivity {
    private Button inscription_btn, connexion_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        this.inscription_btn = (Button) findViewById(R.id.button2);
        this.connexion_btn = (Button) findViewById(R.id.button);
        inscription_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription = new Intent(LoginRegisterActivity.this, Inscription.class);
                startActivity(inscription);
            }
        });

        connexion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(LoginRegisterActivity.this, Authentification.class);
                startActivity(connexion);
            }
        });



    }

}
