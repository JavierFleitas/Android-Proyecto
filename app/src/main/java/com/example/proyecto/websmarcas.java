package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class websmarcas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ImageButton boton1,boton2,boton3,boton4,boton5,boton6;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    String url1="https://www.bmw.es/";
    String url2="https://www.fiat.es/";
    String url3="https://www.ferrari.com/es-ES";
    String url4="https://www.peugeot.es/";
    String url5="https://www.opel.es/";
    String url6="https://www.renault.es/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websmarcas);

        initValues();

        boton1=findViewById(R.id.button1);
        boton2=findViewById(R.id.button2);
        boton3=findViewById(R.id.button3);
        boton4=findViewById(R.id.button4);
        boton5=findViewById(R.id.button5);
        boton6=findViewById(R.id.button6);

        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri link6= Uri.parse(url6);
                Intent i=new Intent(Intent.ACTION_VIEW,link6);
                startActivity(i);

            }
        });

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri link3= Uri.parse(url3);
                Intent i=new Intent(Intent.ACTION_VIEW,link3);
                startActivity(i);

            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link2= Uri.parse(url2);
                Intent i=new Intent(Intent.ACTION_VIEW,link2);
                startActivity(i);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link4= Uri.parse(url4);
                Intent i=new Intent(Intent.ACTION_VIEW,link4);
                startActivity(i);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri link5= Uri.parse(url5);
                Intent i=new Intent(Intent.ACTION_VIEW,link5);
                startActivity(i);
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri link1= Uri.parse(url1);
                Intent i=new Intent(Intent.ACTION_VIEW,link1);
                startActivity(i);

            }
        });

    }

    private void initValues() {

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(websmarcas.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(websmarcas.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(websmarcas.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(websmarcas.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(websmarcas.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                break;
        }
        return true;
    }

}