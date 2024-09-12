package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PedirCita extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    EditText et_nombre, et_dni, et_telefono, et_correo;
    Button b_enviar, b_restablecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_cita);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        et_nombre = findViewById(R.id.et_nombre);
        et_dni = findViewById(R.id.et_dni);
        et_telefono = findViewById(R.id.et_telefono);
        et_correo = findViewById(R.id.et_correo);
        b_enviar = findViewById(R.id.b_enviar);
        b_restablecer = findViewById(R.id.b_restablecer);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        final String sEmail = "";        // Cuenta que envía el correo con los datos introducidos
        final String sPassword = "";     // Contraseña de la cuenta que envía el correo
        final String sEmail2 = "";       // Cuenta que recibe el correo

        b_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                // Inicializar sesion
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail, sPassword);
                    }
                });
                try {
                    // Inicializar contenido email
                    Message message = new MimeMessage(session);
                    // Email que envia
                    message.setFrom(new InternetAddress(sEmail));
                    // Email que recibe
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(sEmail2));
                    // Asunto del email
                    message.setSubject("Nueva solicitud de cita");                                       // REVISAR CUANDO FUNCIONE EL LOGIN Y REGISTRO
                    // Mensaje del email
                    message.setText("Nombre: "+et_nombre.getText().toString().trim()+"\n\nDNI: "+et_dni.getText().toString().trim()+"\n\nTeléfono: "+"\n\nCorreo: "+et_correo.getText().toString().trim());

                    // Enviar email
                    new SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                //Intent intent = new Intent(PedirCita.this, MainActivity.class);                          Cambiar "MainActivity.class" por la clase que va a aparecer al principio dentro de la app
                //startActivity(intent);
                break;
            case R.id.nav_cita:
                break;
            case R.id.nav_nosotros:
                Intent intent1 = new Intent(PedirCita.this, SobreNosotros.class);
                startActivity(intent1);
                break;
            case R.id.nav_venta:
                Intent intent2 = new Intent(PedirCita.this, Venta.class);
                startActivity(intent2);
                break;
            case R.id.nav_logout:
                Intent intent3 = new Intent(PedirCita.this, Login.class);
                startActivity(intent3);
                break;
            case R.id.nav_webs:
                Intent intent4 = new Intent(PedirCita.this, websmarcas.class);
                startActivity(intent4);
                break;
        }
        return true;
    }

    public void restablecer(View view) {
        et_nombre.setText("");
        et_correo.setText("");
        et_telefono.setText("");
        et_dni.setText("");
    }

    private class SendMail extends AsyncTask<Message,String,String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(PedirCita.this, "Por favor, espere", "Enviando solicitud...", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if (s.equals("Success")) {


                AlertDialog.Builder builder = new AlertDialog.Builder(PedirCita.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>¡Perfecto!</font>"));
                builder.setMessage("Solicitud enviada con éxito.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        et_nombre.setText("");
                        et_correo.setText("");
                        et_dni.setText("");
                        et_telefono.setText("");
                    }
                });
                builder.show();
            } else {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }
    }
}