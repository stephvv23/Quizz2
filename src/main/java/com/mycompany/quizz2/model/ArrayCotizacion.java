/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.model;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Stephanie
 */
public class ArrayCotizacion {

    private ArrayList<Cotizacion> listaCotizaciones;

    public ArrayCotizacion() {
        this.getArrayCotizaciones();

    }

    //Metodo para desmenusar el JSONArray e irlos haciendo en objetos y añadiendo al array
    //es buenoi estarlo actualizando cada que guardamos o editamos y eliminamos
    public void getArrayCotizaciones() {
        this.listaCotizaciones = new ArrayList<>();

        JSONFile jsonFile = new JSONFile("cotizaciones.json");
        JSONArray jsonArray = jsonFile.read();

        for (Object object : jsonArray) {

            JSONObject jsonObject = (JSONObject) object;
            Cotizacion cotizacion = new Cotizacion();

            cotizacion.setCodigo(Integer.parseInt(String.valueOf(jsonObject.get("codigo"))));//tener cuidado con las keys
            cotizacion.setPrecioTotal(Double.parseDouble(String.valueOf(jsonObject.get("precio"))));

            ////
            JSONArray paquetesArray = (JSONArray) jsonObject.get("paquetes");
            ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();

            for (Object paqueteObject : paquetesArray) {

                JSONObject paqueteJson = (JSONObject) paqueteObject;

                PaqueteTuristico paqueteAux = new PaqueteTuristico();

                paqueteAux.setCodigo(Integer.parseInt(String.valueOf(paqueteJson.get("codigo"))));//tener cuidado con las keys
                paqueteAux.setDestino(String.valueOf(paqueteJson.get("destino")));
                paqueteAux.setCantidadPasajeros(Integer.parseInt(String.valueOf(paqueteJson.get("pasajeros"))));
                paqueteAux.setPrecio(Double.parseDouble(String.valueOf(paqueteJson.get("precio"))));
                paqueteAux.setDiasViaje(Integer.parseInt(String.valueOf(paqueteJson.get("dias viaje"))));

                paquetes.add(paqueteAux);

            }
            cotizacion.setPaquetes(paquetes);
            this.listaCotizaciones.add(cotizacion);
        }
    }

    public Cotizacion search(int codigo) {
        for (Cotizacion cotizacion : this.listaCotizaciones) {
            if (cotizacion.getCodigo() == codigo) {
                return cotizacion;
            }
        }
        return null;
    }

    public String add(Cotizacion cotizacion) {
        if (cotizacion != null) {
            if (this.search(cotizacion.getCodigo()) == null) {

                JSONFile jsonFile = new JSONFile("cotizaciones.json");
                JSONObject jsonObjectAdd = new JSONObject();

                jsonObjectAdd.put("codigo", cotizacion.getCodigo());
                jsonObjectAdd.put("precio", cotizacion.getPrecioTotal());

                JSONArray arrayPaquetes = new JSONArray();

                for (PaqueteTuristico paquete : cotizacion.getPaquetes()) {

                    JSONObject paqueteJson = new JSONObject();

                    paqueteJson.put("codigo", paquete.getCodigo());
                    paqueteJson.put("precio", paquete.getPrecio());
                    paqueteJson.put("destino", paquete.getDestino());
                    paqueteJson.put("pasajeros", paquete.getCantidadPasajeros());
                    paqueteJson.put("dias viaje", paquete.getDiasViaje());

                    arrayPaquetes.add(paqueteJson);
                }

                jsonObjectAdd.put("paquetes", arrayPaquetes);//se añade en el object general
                this.listaCotizaciones.add(cotizacion);
                jsonFile.writer(jsonObjectAdd);

                return "Cotizacion añadida excitosamente";
            } else {
                return "Codigo ya registrado";
            }
        }
        return "Error añadiendo cotizacion";
    }//fin metodo

    public String delete(Cotizacion cotizacionDelete) {
        if (this.search(cotizacionDelete.getCodigo()) != null) {

            JSONFile jsonFile = new JSONFile("cotizaciones.json");
            JSONArray jsonArrayNew = jsonFile.read();// Lee el contenido actual del archivo

            int index = 0;
            for (Object object : jsonArrayNew) {
                //busca el objeto en el array y lo elimina
                JSONObject objectJson = (JSONObject) object;

                if (String.valueOf(objectJson.get("codigo")).equals(Integer.toString(cotizacionDelete.getCodigo()))) {
                    jsonArrayNew.remove(objectJson);
                    this.listaCotizaciones.remove(index);

                    break;
                }
                index++;
            }
            jsonFile.writerArray(jsonArrayNew);
            return "Cotizacion eliminada correctamente!";
        } else {
            return "Cotizacion no encontrada";
        }
    }

    public String edit(Cotizacion cotizacionEdit) {
        if (this.search(cotizacionEdit.getCodigo()) != null) {

            JSONFile jsonFile = new JSONFile("cotizaciones.json");
            JSONArray jsonArrayNew = jsonFile.read();// Lee el contenido actual del archivo

            int index = 0;
            for (Object object : jsonArrayNew) {
                //busca el objeto en el array y lo elimina
                JSONObject objectJson = (JSONObject) object;
               
                if (String.valueOf(objectJson.get("codigo")).equals(Integer.toString(cotizacionEdit.getCodigo()))) {
                    jsonArrayNew.set(index, object);
                    this.listaCotizaciones.set(index, cotizacionEdit);
                    break;
                }
                 index++;
            }
            jsonFile.writerArray(jsonArrayNew);
            return "Cotizacion editada correctamente ";
        } else {
            return "Codigo no coincide";
        }
    }

    public int getlbCodigo() {
        if (this.listaCotizaciones.size() > 0) {
            return listaCotizaciones.get(listaCotizaciones.size() - 1).getCodigo()+ 1;
        }
        return 1;
    }

    public String[] getCodigoCombo() {
        String[] listaCodigos = new String[this.listaCotizaciones.size()];
        for (int i = 0; i < this.listaCotizaciones.size(); i++) {
            listaCodigos[i] = Integer.toString(this.listaCotizaciones.get(i).getCodigo()) ;
        }
        return listaCodigos;
    }
    
     public String[][] getMatrizCotizaciones() {
        if (!listaCotizaciones.isEmpty()) {
            String[][] matriz = new String[this.listaCotizaciones.size()][Cotizacion.TBL_LABELS.length];
            for (int f = 0; f < matriz.length; f++) {
                for (int c = 0; c < matriz[0].length; c++) {
                    matriz[f][c] = this.listaCotizaciones.get(f).getData(c);
                }

            }
            return matriz;
        }
        return new String[2][2];
    }
}
