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

public class MainActivityPeugeot extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick,NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvlistaPeu;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_peugeot);
        initViews();
        initValues();
    }

    private void initViews(){
        rvlistaPeu = findViewById(R.id.rvListaPeugeot);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvlistaPeu.setLayoutManager(manager);
        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items,this);
        rvlistaPeu.setAdapter(adapterCoches);
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

        itemList.add(new ItemListCoches(R.drawable.peugeot2081,"Peugeot 208", "Precio: 40.964€", "Combustible: Gasolina","Color/s: azul","Potencia: 255 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1220 kg","Capacidad del maletero: 250cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 5","Cilindrada: 4000","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 2,30s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.peugeot5081,"Peugeot 508", "Precio: 109.800€", "Combustible: Diesel/Gasolina ","Color/s: amarillo y rojo","Potencia: 199 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1990 kg","Capacidad del maletero: 190cm","Consumos y emisiones.","Motor.","Numero de cilindros: 9","Cilindrada: 3000","Prestaciones.","Velociad máxima: 240km/h","Aceleración 0-100km/h: 2,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.peugeot50081,"Peugeot 5008", "Precio: 56.000€", "Combustible: Gasolina","Color/s: rojo","Potencia: 105 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2400 kg","Capacidad del maletero: 290cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 7","Cilindrada: 3500","Prestaciones.","Velociad máxima: 210km/h","Aceleración 0-100km/h: 3,70s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.peugeot30081,"Peugeot 3008", "Precio: 63.332€", "Combustible: Gasolina","Color/s: negro","Potencia: 120 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2250 kg","Capacidad del maletero: 340cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 8","Cilindrada: 2900","Prestaciones.","Velociad máxima: 205km/h","Aceleración 0-100km/h: 2,50s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.peugeot20081,"Peugeot 2008", "Precio: 50.000€", "Combustible: Diesel","Color/s: negro y blanco","Potencia: 235 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2000 kg","Capacidad del maletero: 490cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 4","Cilindrada: 2500","Prestaciones.","Velociad máxima: 200km/h","Aceleración 0-100km/h: 1,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.peugeot3081,"Peugeot 308", "Precio: 113.812€", "Combustible: Diesel","Color/s: naranja","Potencia: 210 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2700 kg","Capacidad del maletero: 130cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 5","Cilindrada: 3100","Prestaciones.","Velociad máxima: 260km/h","Aceleración 0-100km/h: 4,00s","Carrocería"));
        return itemList;
    }

    @Override
    public void itemClick(ItemListCoches item) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(MainActivityPeugeot.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityPeugeot.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityPeugeot.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityPeugeot.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityPeugeot.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityPeugeot.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
