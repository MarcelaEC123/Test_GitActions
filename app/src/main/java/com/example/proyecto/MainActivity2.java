package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity  {

    public CheckBox empresa;
    CheckBox estudiante;
    CheckBox discapacitado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        empresa = (CheckBox) findViewById(R.id.empresa);
        estudiante = (CheckBox) findViewById(R.id.estudiante);
        discapacitado = (CheckBox) findViewById(R.id.discapacitado);

    }

    @SuppressLint("SuspiciousIndentation")

    public void onClick(View view) {
        if (view.getId()==R.id.BtnContinuar);
        validar();

    }
    public String validar(){
        String cad ="Ha seleccionado  \n";
        if (empresa.isChecked()==true){
            cad+="Empresa \n";
            Intent hola5 = new Intent(this, MainActivity4.class);
            startActivity(hola5);
        }
        if (discapacitado.isChecked()==true){
            cad+="Persona discapacitada";
            Intent hola5 = new Intent(this, MainActivity3.class);
            startActivity(hola5);
        }
        if (estudiante.isChecked()==true){
            cad+="Estudiante \n";
            Intent hola5 = new Intent(this, MainActivity10.class);
            startActivity(hola5);
        }
        Toast.makeText(getApplicationContext(), cad,Toast.LENGTH_SHORT).show();
        return cad;
    }
}