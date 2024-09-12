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

public class MainActivityRenault extends AppCompatActivity implements RecyclerAdapterCoches.RecyclerItemClick,NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvlistaRenault;
    private RecyclerAdapterCoches adapterCoches;
    private List<ItemListCoches> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_renault);
        initViews();
        initValues();
    }

    private void initViews(){
        rvlistaRenault = findViewById(R.id.rvListaRenault);

    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvlistaRenault.setLayoutManager(manager);

        items = getItems();
        adapterCoches = new RecyclerAdapterCoches(items, this);
        rvlistaRenault.setAdapter(adapterCoches);

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

        itemList.add(new ItemListCoches(R.drawable.renaultarkana1,"Renault Arkana", "Precio: 40.964€", "Combustible: Gasolina","Color/s: amarillo","Potencia: 235 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 1250 kg","Capacidad del maletero: 310cm","Consumos y emisiones.","Motor.","Numero de cilindros: 4","Cilindrada: 2000","Prestaciones.","Velociad máxima: 250km/h","Aceleración 0-100km/h: 3,10s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.renaultkadjar1,"Renault Kadjar", "Precio: 109.800€", "Combustible: Diesel/Gasolina ","Color/s: blanco","Potencia: 135 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 2070 kg","Capacidad del maletero: 220cm","Consumos y emisiones.","Motor.","Numero de cilindros: 5","Cilindrada: 5000","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 3,00s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.renaultkwid1,"Renault Kwid", "Precio: 56.000€", "Combustible: Gasolina","Color/s: blanco y azul","Potencia: 155 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 1990 kg","Capacidad del maletero: 200cm","Consumos y emisiones.","Motor.","Numero de cilindros: 7","Cilindrada: 3000","Prestaciones.","Velociad máxima: 220km/h","Aceleración 0-100km/h: 2,20s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.captur1,"Renault Captur", "Precio: 63.332€", "Combustible: Gasolina","Color/s: negro y naranja","Potencia: 210 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 1444 kg","Capacidad del maletero: 170cm","Consumos y emisiones.","Motor.","Numero de cilindros: 9","Cilindrada: 6000","Prestaciones.","Velociad máxima: 290km/h","Aceleración 0-100km/h: 3,90s","Carrocería"));
        itemList.add(new ItemListCoches(R.drawable.renaultclio,"Renault Clio", "Precio: 50.000€", "Combustible: Diesel","Color/s: naranja","Potencia: 260 CV","Garantia: si","Puertas: 4","Ficha Tecnica.","Detalles del vehiculo","Peso/Masa: 1777 kg","Capacidad del maletero: 150cm","Consumos y emisiones.","Motor.","Numero de cilindros: 3","Cilindrada: 4200","Prestaciones.","Velociad máxima: 210km/h","Aceleración 0-100km/h: 1,88s","Carrocería"));
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
                Intent intent = new Intent(MainActivityRenault.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivityRenault.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(MainActivityRenault.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(MainActivityRenault.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityRenault.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(MainActivityRenault.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
