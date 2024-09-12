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

public class MainActivityFiat extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick,NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvlistaFiat;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fiat);
        initViews();
        initValues();
    }

    private void initViews(){
        rvlistaFiat = findViewById(R.id.rvListaFiat);

    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvlistaFiat.setLayoutManager(manager);

        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items, this);
        rvlistaFiat.setAdapter(adapterCoches);

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

        itemList.add(new ItemListCoches(R.drawable.fiat500x1,"Fiat 500x", "Precio: 40.964€", "Combustible: Gasolina","Color/s: blanco","Potencia: 175 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1070 kg","Capacidad del maletero: 310cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 5","Cilindrada: 2000","Prestaciones.","Velociad máxima: 260km/h","Aceleración 0-100km/h: 3,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.fiatfreemont1,"Fiat Freemont", "Precio: 109.800€", "Combustible: Diesel/Gasolina ","Color/s: azul","Potencia: 105 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 2570 kg","Capacidad del maletero: 500cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 7","Cilindrada: 1000","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 4,50s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.fiatpalio1,"Fiat Palio", "Precio: 56.000€", "Combustible: Gasolina","Color/s: blanco y azul","Potencia: 100 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 4170 kg","Capacidad del maletero: 333cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 3","Cilindrada: 800","Prestaciones.","Velociad máxima: 280km/h","Aceleración 0-100km/h: 2,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.fiatpanda1,"Fiat Panda", "Precio: 63.332€", "Combustible: Gasolina","Color/s: rosa y amarillo","Potencia: 90 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1250 kg","Capacidad del maletero: 453cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 9","Cilindrada: 6000","Prestaciones.","Velociad máxima: 290km/h","Aceleración 0-100km/h: 2,70s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.fiatsedan1,"Fiat Sedan", "Precio: 50.000€", "Combustible: Diesel","Color/s: verde y blanco","Potencia: 120 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 900 kg","Capacidad del maletero: 112cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 3","Cilindrada: 3500","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 4,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.fiattipcross1,"Fiat Cross", "Precio: 113.812€", "Combustible: Diesel","Color/s: negro","Potencia: 140 CV","Garantia: si","Puertas: 4","-Ficha Tecnica.","-Detalles del vehiculo","Peso/Masa: 1900 kg","Capacidad del maletero: 459cm","-Consumos y emisiones.","Motor.","Numero de cilindros: 4","Cilindrada: 1100","Prestaciones.","Velociad máxima: 240km/h","Aceleración 0-100km/h: 3,00s","Carrocería"));
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
                Intent intent = new Intent(MainActivityFiat.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityFiat.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityFiat.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityFiat.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityFiat.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityFiat.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
