package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity8 extends AppCompatActivity {

    private Button abrirF, abrirI, abrirT;
    String urlFace  = "https://es-la.facebook.com/login/device-based/regular/login/";
    String urlIns  = "https://www.instagram.com/";
    String urlTwi  ="https://twitter.com/?lang=es";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        abrirF = (Button) findViewById(R.id.abrirF);
        abrirI = (Button) findViewById(R.id.abrirI);
        abrirT = (Button) findViewById(R.id.abrirT);

        abrirF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(urlFace);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        abrirI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(urlIns);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        abrirT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(urlTwi);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });
    }
    public void funcionParaBttnI(View view) {
        Intent hola = new Intent(this, MainActivity7.class);
        startActivity(hola);
    }

    public void funcionCerrarSesion(View view) {
        Intent hola = new Intent(this, MainActivity.class);
        startActivity(hola);
    }

}