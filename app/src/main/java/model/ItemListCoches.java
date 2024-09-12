package model;

import java.io.Serializable;

public class ItemListCoches implements Serializable {

    private int imgCoche;
    private String modelo;
    private String precio;
    private String combustible;
    private String color;
    private String potencia;
    private String garantia;
    private String puertas;
    private String fichaTecnica;
    private String Detallevehiculo;
    private String pesoMasa;
    private String capacidadmaletero;
    private String consumosyemisiones;
    private String motor;
    private String numerocilindros;
    private String cilindrada;
    private String prestaciones;
    private String velocidadmax;
    private String aceleracion0100;
    private String carroceria;


    public ItemListCoches(int imgCoche, String modelo, String precio, String combustible, String color, String potencia, String garantia, String puertas, String fichaTecnica, String detallevehiculo, String pesoMasa, String capacidadmaletero, String consumosyemisiones, String motor, String numerocilindros, String cilindrada, String prestaciones, String velocidadmax, String aceleracion0100, String carroceria) {
        this.imgCoche = imgCoche;
        this.modelo = modelo;
        this.precio = precio;
        this.combustible = combustible;
        this.color = color;
        this.potencia = potencia;
        this.garantia = garantia;
        this.puertas = puertas;
        this.fichaTecnica = fichaTecnica;
        this.Detallevehiculo = detallevehiculo;
        this.pesoMasa = pesoMasa;
        this.capacidadmaletero = capacidadmaletero;
        this.consumosyemisiones = consumosyemisiones;
        this.motor = motor;
        this.numerocilindros = numerocilindros;
        this.cilindrada = cilindrada;
        this.prestaciones = prestaciones;
        this.velocidadmax = velocidadmax;
        this.aceleracion0100 = aceleracion0100;
        this.carroceria=carroceria;
    }


    public int getImgCoche() {
        return imgCoche;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getColor() {
        return color;
    }

    public String getPotencia() {
        return potencia;
    }

    public String getGarantia() {
        return garantia;
    }

    public String getPuertas() {
        return puertas;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public String getDetallevehiculo() {
        return Detallevehiculo;
    }

    public String getPesoMasa() {
        return pesoMasa;
    }

    public String getCapacidadmaletero() {
        return capacidadmaletero;
    }

    public String getConsumosyemisiones() {
        return consumosyemisiones;
    }

    public String getMotor() {
        return motor;
    }

    public String getNumerocilindros() {
        return numerocilindros;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public String getPrestaciones() {
        return prestaciones;
    }

    public String getVelocidadmax() {
        return velocidadmax;
    }

    public String getAceleracion0100() {
        return aceleracion0100;
    }

    public String getCarroceria(){
        return carroceria;
    }
}
