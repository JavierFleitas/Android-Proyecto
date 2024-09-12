package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.proyecto.MainActivityBMW;
import com.example.proyecto.Utilidades.Utilidades;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerAdapter;
import model.ItemList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initValues();

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);

        rvLista.setAdapter(adapter);

    }
    private List<ItemList> getItems(){
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Opel", "Aqui encontraras todos los vehicilos de la marca Opel   ", R.drawable.opel, "El futuro es de todos"));
        itemLists.add(new ItemList("Ferrari", "Aqui encontraras todos los vehiculos de la marca Ferrari " , R.drawable.ferrari,"Ningún hombre será el mejor si no tiene fuego en la sangre"));
        itemLists.add(new ItemList("Peugeot", "Aqui encontraras todos los vehiculos de la marca ", R.drawable.peugeot, "Peugeot Motion & Emotion"));
        itemLists.add(new ItemList("Renault", "Aqui encontraras todos los vehiculos de la marca Renault  ", R.drawable.renault, "Passion for life"));
        itemLists.add(new ItemList("BMW", "Aqui encontraras todos los vehiculos de la marca BMW  ", R.drawable.bmw, "El placer de conducir"));
        itemLists.add(new ItemList("Fiat", "Aqui encontraras todos los vehiculos de la marca Fiat  ", R.drawable.fiat, "El futuro nos impulsa"));
        return itemLists;
    }


    @Override
    public void itemClick(ItemList item) {
        String nombre = item.getTitulo().toLowerCase();
        switch (nombre){
            case "bmw" : Intent intent = new Intent(this, MainActivityBMW.class);
                        startActivity(intent);
                break;
            case "peugeot": Intent intent1 = new Intent(this, MainActivityPeugeot.class);
                startActivity(intent1);
            break;
            case "fiat": Intent intent2 = new Intent(this, MainActivityFiat.class);
                startActivity(intent2);
                break;
            case "ferrari": Intent intent3 = new Intent(this, MainActivityFerrari.class);
                startActivity(intent3);
                break;
            case "opel": Intent intent4 = new Intent(this, MainActivityOpel.class);
                startActivity(intent4);
                break;
            case "renault": Intent intent5 = new Intent(this, MainActivityRenault.class);
                startActivity(intent5);
                break;

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:

                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(MainActivity.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent = new Intent(MainActivity.this, SobreNosotros.class);
                startActivity(intent);
                break;
            case R.id.nav_venta:
                Intent intent2 = new Intent(MainActivity.this, Venta.class);
                startActivity(intent2);
                break;
            case R.id.nav_logout:
                Intent intent3 = new Intent(MainActivity.this, Login.class);
                startActivity(intent3);
                break;
            case R.id.nav_webs:
                Intent intent4 = new Intent(MainActivity.this, websmarcas.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
}