package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
    }
    public void funcionParaBttnI(View view) {
        Intent hola = new Intent(this, MainActivity8.class);
        startActivity(hola);

    }
    public void funcionCerrarSesion(View view) {
        Intent hola = new Intent(this, MainActivity.class);
        startActivity(hola);
    }
}