package com.example.proyecto.Utilidades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto.Login;
import com.example.proyecto.MainActivity;
import com.example.proyecto.PedirCita;
import com.example.proyecto.R;
import com.example.proyecto.SobreNosotros;
import com.example.proyecto.Venta;
import com.example.proyecto.websmarcas;
import com.google.android.material.navigation.NavigationView;

import model.ItemListCoches;

public class DetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ImageView imgItemDetail;
    private TextView tvModeloDetail;
    private TextView tvPrecioDetail;
    private TextView tvCombustbleDetail;
    private TextView tvPuertasDetail;
    private TextView tvPotenciaDetail;
    private TextView tvColorDetail;
    private TextView tvGarantiaDetail;
    private TextView tvDetallavehiculoDetail;   //titulo
    private TextView tvPesoMasaDetail;
    private TextView tvCapacidadMaleteroDetail;
    private TextView tvConsumosyemisionesDetail;      //titulo
    private TextView tvMotorDetail; //titulo
    private TextView tvNumeroCilindrosDetail;
    private TextView tvCilindradaDetail;
    private TextView tvPrestacionesDetail;        //titulo
    private TextView tvfichaTecnicaDetail;       //titulo
    private TextView tvVelocidadmaxDetail;
    private TextView tvaceleracion0100Detail;
    private TextView tvCarroceriaDetail;        //titulo

    private ItemListCoches itemDetail;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());

        initView();
        initValues();

    }

    private void initView() {

        imgItemDetail=findViewById(R.id.imgItemDetail);
        tvModeloDetail=findViewById(R.id.tvModeloDetail);
        tvPrecioDetail=findViewById(R.id.tvPrecioDetail);
        tvCombustbleDetail=findViewById(R.id.tvCombistibleDetail);
        tvColorDetail=findViewById(R.id.tvColorDetail);
        tvPuertasDetail=findViewById(R.id.tvPuertasDetail);
        tvPotenciaDetail=findViewById(R.id.tvPotenciaDetail);
        tvGarantiaDetail=findViewById(R.id.tvGarantiaDetail);

        tvDetallavehiculoDetail=findViewById(R.id.tvDetallavehiculoDetail);
        tvPesoMasaDetail=findViewById(R.id.tvPesoMasaDetail);
        tvCapacidadMaleteroDetail=findViewById(R.id.tvCapacidadMaleteroDetail);
        tvConsumosyemisionesDetail=findViewById(R.id.tvConsumosyemisionesDetail);
        tvMotorDetail=findViewById(R.id.tvMotorDetail);
        tvNumeroCilindrosDetail=findViewById(R.id.tvNumeroCilindrosDetail);
        tvCilindradaDetail=findViewById(R.id.tvCilindradaDetail);
        tvPrestacionesDetail=findViewById(R.id.tvPrestacionesDetail);
        tvfichaTecnicaDetail=findViewById(R.id.tvfichaTecnicaDetail);
        tvVelocidadmaxDetail=findViewById(R.id.tvVelocidadmaxDetail);
        tvaceleracion0100Detail=findViewById(R.id.tvaceleracion0100Detail);
        tvCarroceriaDetail=findViewById(R.id.tvCarroceriaDetail);


    }

    private void initValues() {

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        itemDetail = (ItemListCoches) getIntent().getExtras().getSerializable("itemDetail");

        imgItemDetail.setImageResource(itemDetail.getImgCoche());
        tvModeloDetail.setText(itemDetail.getModelo());
        tvPrecioDetail.setText(itemDetail.getPrecio());
        tvCombustbleDetail.setText(itemDetail.getCombustible());
        tvColorDetail.setText(itemDetail.getColor());
        tvPuertasDetail.setText(itemDetail.getPuertas());
        tvPotenciaDetail.setText(itemDetail.getPotencia());
        tvGarantiaDetail.setText(itemDetail.getGarantia());
        tvDetallavehiculoDetail.setText(itemDetail.getDetallevehiculo());
        tvPesoMasaDetail.setText(itemDetail.getPesoMasa());
        tvCapacidadMaleteroDetail.setText(itemDetail.getCapacidadmaletero());
        tvConsumosyemisionesDetail.setText(itemDetail.getConsumosyemisiones());
        tvMotorDetail.setText(itemDetail.getMotor());
        tvNumeroCilindrosDetail.setText(itemDetail.getNumerocilindros());
        tvCilindradaDetail.setText(itemDetail.getCilindrada());
        tvPrestacionesDetail.setText(itemDetail.getPrestaciones());
        tvfichaTecnicaDetail.setText(itemDetail.getFichaTecnica());
        tvVelocidadmaxDetail.setText(itemDetail.getVelocidadmax());
        tvaceleracion0100Detail.setText(itemDetail.getAceleracion0100());
        tvCarroceriaDetail.setText(itemDetail.getCarroceria());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_cita:
                Intent intent1 = new Intent(DetailActivity.this, PedirCita.class);
                startActivity(intent1);
                break;
            case R.id.nav_nosotros:
                Intent intent2 = new Intent(DetailActivity.this, SobreNosotros.class);
                startActivity(intent2);
                break;
            case R.id.nav_venta:
                Intent intent3 = new Intent(DetailActivity.this, Venta.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(DetailActivity.this, Login.class);
                startActivity(intent4);
                break;
            case R.id.nav_webs:
                Intent intent5 = new Intent(DetailActivity.this, websmarcas.class);
                startActivity(intent5);
                break;
        }
        return true;
    }


}