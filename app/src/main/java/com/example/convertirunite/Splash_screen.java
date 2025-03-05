package com.example.convertirunite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_screen extends AppCompatActivity {

    private final int temps_attente = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    //Rediriger vers la page d'accueil
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Pour aller a la page d'accueil
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

        },temps_attente);
    }
}