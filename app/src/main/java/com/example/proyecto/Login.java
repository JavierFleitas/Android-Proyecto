package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText et_correo, et_password;
    Button b_entrar;

    private FirebaseAuth Lauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_correo = (EditText) findViewById(R.id.et_correo);
        et_password = (EditText) findViewById(R.id.et_password);
        b_entrar = findViewById(R.id.b_entrar);

        Lauth = FirebaseAuth.getInstance();

        b_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

    }

    private void userLogin() {

        String email = et_correo.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        if (email.isEmpty()){

            et_correo.setError("Correo requerido");
            et_correo.requestFocus();
            return;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            et_correo.setError("Por favor introduce un correo válido");
            et_correo.requestFocus();
            return;

        }

        if (password.isEmpty()){

            et_password.setError("La contraseña es requerida");
            et_password.requestFocus();
            return;

        }

        if (password.length() > 20){

            et_password.setError("El máximo de caracteres es 20");
            et_password.requestFocus();
            return;

        }

        Lauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    startActivity(new Intent(Login.this,MainActivity.class));

                }else{

                    Toast.makeText(Login.this, "Error, comprueba las credenciales", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}