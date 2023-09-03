package com.example.proyecto;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    public MenuItem empresa;
    private EditText txtUsuario;
    private EditText txtContraseña;
    private Button BtnIngresar;

    // VARIABLES DE LOS DATOS QUE VAMOS A REGISTRAR
    private String Email = " ";
    private String password = " ";

    public FirebaseAuth Auth;
    DatabaseReference Database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_Proyecto);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth = FirebaseAuth.getInstance();
        Database = FirebaseDatabase.getInstance().getReference();

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        BtnIngresar = (Button) findViewById(R.id.BtnIngresar);

        BtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = txtUsuario.getText().toString();
                password = txtContraseña.getText().toString();

                if (!Email.isEmpty() && !password.isEmpty()) {
                    loginUser();
                } else {
                    Toast.makeText(MainActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void loginUser() {
        Auth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(MainActivity.this, MainActivity9.class));
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void funcionParaBttnI(View view) {
        Intent hola = new Intent(this, MainActivity2.class);
        startActivity(hola);

    }

    public String validar() {

        return null;
    }

}