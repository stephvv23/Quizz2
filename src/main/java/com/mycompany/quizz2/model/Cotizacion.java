/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cotizacion {

    private ArrayList<PaqueteTuristico> paquetes;
    private double precioTotal;
    private int codigo;
    public static final String[] TBL_LABELS = {"Codigo", "Precio"};

    public Cotizacion() {
    }

    public Cotizacion(int codigo) {
        this.codigo = codigo;
    }

    public String getData(int colum) {
        switch (colum) {
            case 0:
                return String.valueOf(this.getCodigo());
            case 1:
                return String.valueOf(this.getPrecioTotal());
        }
        return "";
    }

    public ArrayList<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public String[][] getMatrizPaquetesVector() {

        String[][] matriz = new String[this.paquetes.size()][PaqueteTuristico.TBL_LABELS.length];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                matriz[f][c] = this.paquetes.get(f).getData(c);
            }

        }
        return matriz;

    }

    public void setPaquetes(ArrayList<PaqueteTuristico> paquetes) {
        this.paquetes = paquetes;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
