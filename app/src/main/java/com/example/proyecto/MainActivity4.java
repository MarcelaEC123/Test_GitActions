package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    private EditText txtNombre_1, txtNit, txtSector, txtCiudad_1, txtTelefono_1, txtEmail_1, txtUsuario_1, txtPassword_1;
    private Button btnRegistrar;

    //VARIABLES DE LOS DATO A REGISTRAR

    private String Nombre = "";
    private String Email = "";
    private String Password = "";

    FirebaseAuth Auth;
    DatabaseReference Database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Auth = FirebaseAuth.getInstance();
        Database = FirebaseDatabase.getInstance().getReference();
        txtNombre_1 = (EditText) findViewById(R.id.txtNombre_1);
        txtNit =(EditText)  findViewById(R.id.txtNit);
        txtSector = (EditText)  findViewById(R.id.txtSector);
        txtCiudad_1 = (EditText)  findViewById(R.id.txtCiudad_1);
        txtTelefono_1 = (EditText)  findViewById(R.id.txtTelefono_1);
        txtEmail_1 = (EditText)  findViewById(R.id.txtEmail_1);
        txtUsuario_1 = (EditText)  findViewById(R.id.txtUsuario_1);
        txtPassword_1 = (EditText)  findViewById(R.id.txtPassword_1);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre = txtNombre_1.getText().toString();
                Email = txtEmail_1.getText().toString();
                Password = txtPassword_1.getText().toString();

                if (!Nombre.isEmpty() && !Email.isEmpty() && !Password.isEmpty()) {
                    if (txtPassword_1.length() >= 6) {
                        registerUser();
                    } else {
                        Toast.makeText(com.example.proyecto.MainActivity4.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(com.example.proyecto.MainActivity4.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    private void registerUser() {
        Auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre", Nombre);
                    map.put("Email", Email);
                    map.put("Password", Password);

                    String id = Auth.getCurrentUser().getUid();
                    Database.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                Toast.makeText(MainActivity4.this, "Usuario Registrado correctamente, Inicie sesiòn ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(com.example.proyecto.MainActivity4.this, MainActivity.class));
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(com.example.proyecto.MainActivity4.this, "No se pudo registrar esta empresa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void funcionParaBttnI(View view) {
        Intent hola = new Intent(this, MainActivity9.class);
        startActivity(hola);

    }

    public void funcionParaBttMapa(View view) {
        Intent hola = new Intent(this, MainActivity6.class);
        startActivity(hola);

    }

}