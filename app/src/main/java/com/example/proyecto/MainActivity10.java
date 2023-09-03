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

public class MainActivity10 extends AppCompatActivity {

    private EditText txtNombre_2, txtCedula_2,txtEstudio, txtCiudad_2, txtFecha_2, txtTelefono_2, txtEmail_2, txtUsuario_2, txtPassword_2;
    private Button btnbus, btnmod, btnreg, btneli;

    //VARIABLES DE LOS DATOA A REGISTRAR

    private String Nombre ="";
    private String  Email ="";
    private  String Password ="";

    FirebaseAuth Auth;
    DatabaseReference Database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Auth = FirebaseAuth.getInstance();
        Database = FirebaseDatabase.getInstance().getReference();
        txtNombre_2 = (EditText) findViewById(R.id.txtNombre_2);
        txtCedula_2 = (EditText) findViewById(R.id.txtCedula_2);
        txtEstudio = (EditText) findViewById(R.id.txtEstudio);
        txtCiudad_2 = (EditText) findViewById(R.id.txtCiudad_2);
        txtFecha_2 = (EditText) findViewById(R.id.txtFecha_2);
        txtTelefono_2 = (EditText) findViewById(R.id.txtTelefono_2);
        txtEmail_2 = (EditText) findViewById(R.id.txtEmail_2);
        txtUsuario_2 = (EditText) findViewById(R.id.txtUsuario_2);
        txtPassword_2 = (EditText) findViewById(R.id.txtPassword_2);
        btnreg = (Button) findViewById(R.id.btnRegistrar_2);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nombre = txtNombre_2.getText().toString();
                Email =  txtEmail_2.getText().toString();
                Password =  txtPassword_2.getText().toString();

                if (!Nombre.isEmpty() && !Email.isEmpty() && !Password.isEmpty()){
                    if(txtPassword_2.length()>=6){
                        registerUser();
                    }else{
                        Toast.makeText(MainActivity10.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity10.this, "Debe completarlos campos", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    private void registerUser(){
        Auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre",Nombre);
                    map.put("Email",Email);
                    map.put("Password",Password);

                    String id = Auth.getCurrentUser().getUid();
                    Database.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Toast.makeText(MainActivity10.this, "Usuario Registrado correctamente, Inicie sesiòn ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity10.this, MainActivity.class));
                                finish();

                            }

                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity10.this, "No se pudo registrar este Usuario", Toast.LENGTH_SHORT).show();
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