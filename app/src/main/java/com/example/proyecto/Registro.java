package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.proyecto.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    EditText et_nombre, et_correo, et_password;
    Button b_registrarse;

    // VARIABLES DE LOS DATOS A ALMACENAR
    private String sNombre = "";
    private String sCorreo = "";
    private String sPassword = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_correo = (EditText) findViewById(R.id.et_correo);
        et_password = (EditText) findViewById(R.id.et_password);

        b_registrarse = findViewById(R.id.b_registrarse);

        b_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sNombre = et_nombre.getText().toString().trim();
                sCorreo = et_correo.getText().toString().trim();
                sPassword = et_password.getText().toString().trim();
            }
        });

        if (!sNombre.isEmpty() && !sCorreo.isEmpty() && !sPassword.isEmpty()) {

            if (sPassword.length() >= 6) {
                registerUser();
            } else {
                Toast.makeText(Registro.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Registro.this, "Debe completar los campos.", Toast.LENGTH_SHORT).show();
        }
    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(sCorreo, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("correo", et_correo);
                    map.put("password", et_password);


                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(Registro.this, Login.class));
                                finish();
                            } else {
                                Toast.makeText(Registro.this, "No se pudo registrar el usuario correctamente.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(Registro.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }

        });
        Intent continuar = new Intent(this, Login.class);
        startActivity(continuar);
    }

    public void Volver(View view) {
        Intent intent = new Intent(Registro.this, Login.class);
        startActivity(intent);
    }
}