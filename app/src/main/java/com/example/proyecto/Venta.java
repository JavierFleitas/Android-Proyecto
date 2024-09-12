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

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class Venta extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    EditText et_modelo, et_nombre, et_telefono, et_correo;
    Button b_enviar, b_restablecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        et_modelo = findViewById(R.id.et_modelo);
        et_nombre = findViewById(R.id.et_nombre);
        et_telefono = findViewById(R.id.et_telefono);
        et_correo = findViewById(R.id.et_correo);
        b_enviar = findViewById(R.id.b_enviar);
        b_restablecer = findViewById(R.id.b_restablecer);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        final String sEmail = "koksalautos@gmail.com";        // Cuenta que envía el correo con los datos introducidos
        final String sPassword = "proyecto21.";     // Contraseña de la cuenta que envía el correo
        final String sEmail2 = "marcos.arg1998@gmail.com";       // Cuenta que recibe el correo

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
                    message.setSubject("Nueva solicitud de venta");
                    // Mensaje del email
                    message.setText("Modelo y marca: "+et_modelo.getText().toString().trim()+"\n\nNombre: "+et_nombre.getText().toString().trim()+"\n\nTeléfono: "+"\n\nCorreo: "+et_correo.getText().toString().trim());

                    // Enviar email
                    new Venta.SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void restablecer(View view) {
        et_nombre.setText("");
        et_correo.setText("");
        et_telefono.setText("");
        et_modelo.setText("");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(Venta.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent2 = new Intent(Venta.this, PedirCita.class);
                startActivity(intent2);
                break;
            case R.id.nav_nosotros:
                Intent intent1 = new Intent(Venta.this, SobreNosotros.class);
                startActivity(intent1);
                break;
            case R.id.nav_venta:
                break;
            case R.id.nav_logout:
                Intent intent3 = new Intent(Venta.this, Login.class);
                startActivity(intent3);
                break;
            case R.id.nav_webs:
                Intent intent4 = new Intent(Venta.this, websmarcas.class);
                startActivity(intent4);
                break;

        }
        return true;
    }

    private class SendMail extends AsyncTask<Message,String,String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Venta.this, "Por favor, espere", "Enviando solicitud...", true, false);
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


                AlertDialog.Builder builder = new AlertDialog.Builder(Venta.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>¡Perfecto!</font>"));
                builder.setMessage("Solicitud enviada con éxito.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        et_modelo.setText("");
                        et_nombre.setText("");
                        et_correo.setText("");
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