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

public class MainActivityOpel extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick,NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvlistaOpel;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_opel);
        initViews();
        initValues();
    }

    private void initViews(){
        rvlistaOpel = findViewById(R.id.rvListaOpel);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvlistaOpel.setLayoutManager(manager);

        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items,this);
        rvlistaOpel.setAdapter(adapterCoches);
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

        itemList.add(new ItemListCoches(R.drawable.opelastra1,"Opel Astra", "Precio: 40.964€", "Combustible: Gasolina","Color/s: blanco","Potencia: 155 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1330 kg","Capacidad del maletero: 440cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 6","Cilindrada: 2000","Prestaciones.","Velociad máxima: 290km/h","Aceleración 0-100km/h: 3,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.opelgrandland1,"Opel GranLand X turbo", "Precio: 20.000", "Combustible: Diesel/Gasolina ","Color/s: azul","Potencia: 132 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 1110 kg","Capacidad del maletero: 320cm","Consumos y emisiones.","Motor.","Numero de cilindros: 5","Cilindrada: 3000","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 3,00s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.opelinsigna1,"Opel Insigna", "Precio: 56.000€", "Combustible: Gasolina","Color/s: verde y blanco","Potencia: 200 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1980 kg","Capacidad del maletero: 220cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 7","Cilindrada: 5000","Prestaciones.","Velociad máxima: 210km/h","Aceleración 0-100km/h: 4,50s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.opelzafira,"Opel Zafira", "Precio: 63.332€", "Combustible: Gasolina","Color/s: negro y naranja","Potencia: 99 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1666 kg","Capacidad del maletero: 470cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 4","Cilindrada: 1000","Prestaciones.","Velociad máxima: 260km/h","Aceleración 0-100km/h: 1,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.mokka,"Opel Mokka", "Precio: 50.000€", "Combustible: Diesel","Color/s: naranja","Potencia: 120 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2200 kg","Capacidad del maletero: 100cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 10","Cilindrada: 4000","Prestaciones.","Velociad máxima: 200km/h","Aceleración 0-100km/h: 2,80s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.crossland,"Opel Crossland", "Precio: 113.812€", "Combustible: Diesel","Color/s: rojo","Potencia: 188 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1223 kg","Capacidad del maletero: 180cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 12","Cilindrada: 2500","Prestaciones.","Velociad máxima: 190km/h","Aceleración 0-100km/h: 4,70s","Carrocería"));
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
                Intent intent = new Intent(MainActivityOpel.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityOpel.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityOpel.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityOpel.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityOpel.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityOpel.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
