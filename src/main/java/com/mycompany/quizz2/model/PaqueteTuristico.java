/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.model;

import com.opencsv.bean.CsvBindByName;

/**
 *
 * @author Usuario
 */
public class PaqueteTuristico {
    @CsvBindByName
    private int cantidadPasajeros;
    @CsvBindByName
    private int codigo;
    @CsvBindByName
    private String destino;
    @CsvBindByName
    private double precio;
    @CsvBindByName
    private int diasViaje;
    
    public static final String[] TBL_LABELS = { "Codigo","Cantidad pasajeros", "Destino", "Precio", "Dias de viaje"};

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int cantidadPasajeros, int codigo, String destino, double precio, int diasViaje) {
        this.cantidadPasajeros = cantidadPasajeros;
        this.codigo = codigo;
        this.destino = destino;
        this.precio = precio;
        this.diasViaje = diasViaje;
    }
    
     public String getData(int colum){
        switch (colum) {
            case 0: return String.valueOf(this.getCodigo());
            case 1: return String.valueOf(this.getCantidadPasajeros());
            case 2: return String.valueOf(this.getDestino());
            case 3: return String.valueOf(this.getPrecio());
            case 4: return String.valueOf(this.getDiasViaje());
        }
        return "";
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiasViaje() {
        return diasViaje;
    }

    public void setDiasViaje(int diasViaje) {
        this.diasViaje = diasViaje;
    }

  
    
}
