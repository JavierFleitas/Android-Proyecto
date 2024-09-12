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
import model.ItemList;
import model.ItemListCoches;

public class MainActivityBMW extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvlistabmw;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b_m_w);
        initViews();
        initValues();
    }

    private void initViews(){
        rvlistabmw = findViewById(R.id.rvListaBMW);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvlistabmw.setLayoutManager(manager);

        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items,this);
        rvlistabmw.setAdapter(adapterCoches);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private List<ItemListCoches> getItems(){
        List<ItemListCoches> itemList = new ArrayList<>();

        itemList.add(new ItemListCoches(R.drawable.bmwberlina1,"BMW Berlina", "Precio: 40.964€", "Combustible: Gasolina","Color/s: blanco y azul","Potencia: 175 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1570 kg","Capacidad del maletero: 380cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 7","Cilindrada: 3000","Prestaciones.","Velociad máxima: 250km/h","Aceleración 0-100km/h: 3,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.bmwserie720201,"BMW 7 2020", "Precio:109.800€", "Combustible: Diesel/Gasolina ","Color/s: blanco y verde","Potencia: 200cv","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2000 kg","Capacidad del maletero: 430cm","-Consumos y emisiones.","Motor","Numero de cilindros: 10","Cilindrada: 4000","Prestaciones","Velociad máxima: 300km/h","Aceleración 0-100km/h: 4,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.bmwx41,"BMW X4", "Precio: 56.000€", "Combustible: Gasolina","Color/s: blanco y rosa","Potencia: 200 CV","Garantia: no","Puertas: 4","Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2200 kg","Capacidad del maletero: 500cm","-Consumos y emisiones.","Motor","Numero de cilindros: 5","Cilindrada: 2000","Prestaciones","Velociad máxima: 280km/h","Aceleración 0-100km/h: 1,40s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.bmwx5xdrive45e1,"BMW X5 Drive", "Precio: 63.332€", "Combustible: Gasolina","Color/s: negro y blanco","Potencia: 210 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1000 kg","Capacidad del maletero: 200cm","-Consumos y emisiones.","Motor","Numero de cilindros: 15","Cilindrada: 2500","Prestaciones","Velociad máxima: 220km/h","Aceleración 0-100km/h: 2,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.mbwmf1,"BMW M5 F10 ", "Precio: 50.000€", "Combustible: Diesel","Color/s: rosa y verde","Potencia: 250 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2500 kg","Capacidad del maletero: 189cm","-Consumos y emisiones.","Motor","Numero de cilindros: 3","Cilindrada: 3200","Prestaciones","Velociad máxima: 200km/h","Aceleración 0-100km/h: 2,80s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.bmwm6g1,"BMW M6 GC", "Precio: 113.812€", "Combustible: Diesel","Color/s: blanco","Potencia: 222 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2050 kg","Capacidad del maletero: 444cm","-Consumos y emisiones.","Motor","Numero de cilindros: 9","Cilindrada: 6000","Prestaciones","Velociad máxima: 270km/h","Aceleración 0-100km/h: 2,0s","Carrocería"));
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
                Intent intent = new Intent(MainActivityBMW.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityBMW.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityBMW.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityBMW.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityBMW.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityBMW.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }


}
