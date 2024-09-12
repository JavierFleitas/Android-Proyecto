package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.Utilidades.DetailActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;
import adapter.RecyclerAdapterCoches;
import model.ItemListCoches;

public class MainActivityFerrari  extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvListaFerrari;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ferrari);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        initViws();
        initValues();
    }

    private void initViws(){
        rvListaFerrari = findViewById(R.id.rvListaFerrari);

    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvListaFerrari.setLayoutManager(manager);
        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items, this);
        rvListaFerrari.setAdapter(adapterCoches);


    }

    private List<ItemListCoches> getItems(){
        List<ItemListCoches> itemList = new ArrayList<>();
        itemList.add(new ItemListCoches(R.drawable.ferrarif12tdf1,"Ferrari 12 TDF", "Precio: 40.964€", "Combustible: Gasolina","Color/s: rojo y azul","Potencia: 535 CV","Garantia: si","Puertas: 2","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 4500 kg","Capacidad del maletero: 100cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 13","Cilindrada: 3000","Prestaciones.","Velociad máxima: 350km/h","Aceleración 0-100km/h: 2,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.ferrari20141,"LaFerrari 2014", "Precio: 109.800€", "Combustible: Diesel/Gasolina ","Color/s: rojo y amarillo","Potencia: 475 CV","Garantia: si","Puertas: 2","Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 3000 kg","Capacidad del maletero: 230cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 10","Cilindrada: 4000","Prestaciones.","Velociad máxima: 280km/h","Aceleración 0-100km/h: 1,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.ferrari4301,"Ferrari 430", "Precio: 56.000€", "Combustible: Gasolina","Color/s: rojo","Potencia: 405 CV","Garantia: si","Puertas: 2","-Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 2370 kg","Capacidad del maletero: 380cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 17","Cilindrada: 5000","Prestaciones.","Velociad máxima: 300km/h","Aceleración 0-100km/h: 3,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.ferrari458speciale1,"Ferrari 458 Speciale", "Precio: 63.332€", "Combustible: Gasolina","Color/s: blanco","Potencia: 770 CV","Garantia: si","Puertas: 2","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1700 kg","Capacidad del maletero: 380cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 8","Cilindrada: 6000","Prestaciones.","Velociad máxima: 210km/h","Aceleración 0-100km/h: 3,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.ferrari599xxevo1,"Ferrari 599XX Evo  ", "Precio: 50.000€", "Combustible: Diesel","Color/s: amarillo y azul","Potencia: 295 CV","Garantia: si","Puertas: 2","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 7000 kg","Capacidad del maletero: 550cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 20","Cilindrada: 7000","Prestaciones.","Velociad máxima: 190km/h","Aceleración 0-100km/h: 2,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.ferrarif401,"Ferrari F40 ", "Precio: 113.812€", "Combustible: Diesel","Color/s: blanco y verde","Potencia: 615 CV","Garantia: si","Puertas: 2","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 5000 kg","Capacidad del maletero: 90cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 22","Cilindrada: 8000","Prestaciones.","Velociad máxima: 450km/h","Aceleración 0-100km/h: 1,20s","Carrocería"));
        return itemList;
    }

    @Override
    public void itemClick(ItemListCoches item) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(MainActivityFerrari.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityFerrari.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityFerrari.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityFerrari.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityFerrari.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityFerrari.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
