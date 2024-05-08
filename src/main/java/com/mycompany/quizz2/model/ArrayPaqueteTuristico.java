/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.model;

import static com.mycompany.quizz2.model.CSVHandler.escribirCSV;
import static com.mycompany.quizz2.model.CSVHandler.leerCSV;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Usuario
 */
public class ArrayPaqueteTuristico {

    private ArrayList<PaqueteTuristico> listaPaquetesDisponibles;
    private ArrayList<PaqueteTuristico> listaPaquetesSeleccionados;

    public ArrayPaqueteTuristico() {

        try {
            File file = new File("paquetesTuristicos.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            this.listaPaquetesDisponibles = leerCSV("paquetesTuristicos.csv");
            escribirCSV(listaPaquetesDisponibles, "paquetesTuristicos.csv");

        } catch (IOException ex) {
            System.err.println("Error al escribir");
        }

        this.listaPaquetesSeleccionados = new ArrayList<>();
    }

    public void setListaPaquetesSeleccionados(ArrayList<PaqueteTuristico> listaPaquetesSeleccionados) {
        this.listaPaquetesSeleccionados = listaPaquetesSeleccionados;
    }

    public PaqueteTuristico search(int codigo) {
        for (PaqueteTuristico paquete : this.listaPaquetesDisponibles) {
            if (paquete.getCodigo() == codigo) {
                return paquete;
            }
        }
        return null;
    }

    public boolean searchBoolean(int codigo) {
        for (PaqueteTuristico paquete : this.listaPaquetesDisponibles) {
            if (paquete.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public String add(PaqueteTuristico paquete) {
        if (!searchBoolean(paquete.getCodigo())) {
            try {

                listaPaquetesDisponibles.add(paquete);

                escribirCSV(listaPaquetesDisponibles, "paquetesTuristicos.csv");
                return "Agregado con exito";
            } catch (IOException ex) {
                return "Error al añadir";
            }
        }
        return "Codigo existente";
    }//fin metodo

    public String delete(PaqueteTuristico paquete) {
        if (searchBoolean(paquete.getCodigo())) {
            try {

                listaPaquetesDisponibles.remove(this.search(paquete.getCodigo()));

                escribirCSV(listaPaquetesDisponibles, "paquetesTuristicos.csv");
                return "Eliminado con exito";
            } catch (IOException ex) {
                return "Error al eliminar";
            }
        }
        return "No se encontro un paquete con ese codigo";
    }

    public String edit(PaqueteTuristico paqueteEdit) {
        for (int i = 0; i < this.listaPaquetesDisponibles.size(); i++) {
            if (this.listaPaquetesDisponibles.get(i).getCodigo() == paqueteEdit.getCodigo()) {
                try {

                    this.listaPaquetesDisponibles.set(i, paqueteEdit);

                    escribirCSV(listaPaquetesDisponibles, "paquetesTuristicos.csv");
                    return "Editado con exito";
                } catch (IOException ex) {
                    return "Error al eliminar";
                }
            }
        }
        return "Error while modified song";
    }

    public int getCodigosPaquetes() {
        if (this.listaPaquetesDisponibles.size() > 0) {
            return listaPaquetesDisponibles.get(listaPaquetesDisponibles.size() - 1).getCodigo() + 1;
        }
        return 1;
    }

    public String[] getComboCodigos() {
        if (!listaPaquetesDisponibles.isEmpty()) {
            String[] codigos = new String[this.listaPaquetesDisponibles.size()];

            for (int i = 0; i < this.listaPaquetesDisponibles.size(); i++) {
                codigos[i] = Integer.toString(this.listaPaquetesDisponibles.get(i).getCodigo());
            }
            return codigos;
        }
        return new String[1];

    }

    public String[][] getMatrizPaquetesDisponibles() {
        if (!listaPaquetesDisponibles.isEmpty()) {
            String[][] matrizPaquetesDisponibles = new String[this.listaPaquetesDisponibles.size()][PaqueteTuristico.TBL_LABELS.length];
            for (int f = 0; f < matrizPaquetesDisponibles.length; f++) {
                for (int c = 0; c < matrizPaquetesDisponibles[0].length; c++) {
                    matrizPaquetesDisponibles[f][c] = this.listaPaquetesDisponibles.get(f).getData(c);
                }

            }
            return matrizPaquetesDisponibles;
        }
        return new String[2][2];
    }

    public boolean searchPaquetesSeleccionados(PaqueteTuristico paquete) {
        for (int i = 0; i < listaPaquetesSeleccionados.size(); i++) {
            if (paquete.getCodigo() == listaPaquetesSeleccionados.get(i).getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public void addPaquetesSeleccionados(PaqueteTuristico paquete) {
        if (searchPaquetesSeleccionados(paquete) == false) {
            this.listaPaquetesSeleccionados.add(paquete);
        }
    }

    public ArrayList getListaPaquetesSeleccionados() {
        return listaPaquetesSeleccionados;
    }

    public double getPrecioTotal() {
        double total = 0;
        for (PaqueteTuristico paqueteSeleccionado : listaPaquetesSeleccionados) {
            total += paqueteSeleccionado.getPrecio();
        }
        return total;
    }

    public void deletePaqueteSeleccionado(int index) {
        this.listaPaquetesSeleccionados.remove(index);
    }

    public String[][] getMatrizPaquetesSeleccionados() {
        String[][] matrixData = new String[this.listaPaquetesSeleccionados.size()][PaqueteTuristico.TBL_LABELS.length];
        if (listaPaquetesSeleccionados != null) {
            for (int f = 0; f < matrixData.length; f++) {
                for (int c = 0; c < matrixData[0].length; c++) {
                    matrixData[f][c] = this.listaPaquetesSeleccionados.get(f).getData(c);
                }

            }
            return matrixData;
        }
        return null;
    }

    //Metodo para limpiar el array

    public void limpiarListaSeleccionados() {
        this.listaPaquetesSeleccionados = new ArrayList<>();
    }
}
