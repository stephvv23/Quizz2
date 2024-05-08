/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.controller;

import com.mycompany.quizz2.model.ArrayPaqueteTuristico;
import com.mycompany.quizz2.model.PaqueteTuristico;
import com.mycompany.quizz2.view.DataPanelBotones;
import com.mycompany.quizz2.view.DataPanelPaquete;
import com.mycompany.quizz2.view.GUIPaqueteTuristico;
import com.mycompany.quizz2.view.GUIReport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author Usuario
 */
public class ControladorPaqueteTuristico implements ActionListener{

    private ArrayPaqueteTuristico paqueteArray;
    private GUIPaqueteTuristico guiPaquete;
    private DataPanelBotones panelBotones;
    private DataPanelPaquete panelPaquete;
    private GUIReport guiReport;

    public ControladorPaqueteTuristico(ArrayPaqueteTuristico paqueteArray) {

        this.guiPaquete = new GUIPaqueteTuristico();
        this.panelPaquete = this.guiPaquete.getDataPanelPaquete1();
        this.panelBotones = this.guiPaquete.getDataPanelBotones1();
        this.panelBotones.listen(this);
        this.panelPaquete.listenCbPaquetesRegistrados(this);

        this.paqueteArray = paqueteArray;
        this.panelPaquete.setCbPaquetesRegistrados(this.paqueteArray.getComboCodigos());
        this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());

        this.panelPaquete.setCBDestinos(new String[]{"Seleccione", "Tambor", "Cancun", "Colombia"});
        this.panelPaquete.setCbPaquetesRegistrados(this.paqueteArray.getComboCodigos());
        this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());

        this.guiPaquete.setVisible(true);
    }

    public boolean validarPaquete(PaqueteTuristico paquete) {
        if (paquete.getDestino().equalsIgnoreCase("Seleccione")) {
            GUIPaqueteTuristico.enviarMensaje("El Destino no esta seleccionado");
            return false;
        } else if (paquete.getPrecio() <= 0) {
            GUIPaqueteTuristico.enviarMensaje("El precio no esta definido");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Añadir":
                if (validarPaquete(this.panelPaquete.getPaquete())) {

                    GUIPaqueteTuristico.enviarMensaje(this.paqueteArray.add(this.panelPaquete.getPaquete()));
                    this.panelPaquete.limpiar();
                    this.panelPaquete.setCbPaquetesRegistrados(this.paqueteArray.getComboCodigos());
                    this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());
                }
                break;
            case "Editar":
                if (validarPaquete(this.panelPaquete.getPaquete())) {

                    GUIPaqueteTuristico.enviarMensaje(this.paqueteArray.edit(this.panelPaquete.getPaquete()));
                    this.panelPaquete.limpiar();
                    this.panelPaquete.setCbPaquetesRegistrados(this.paqueteArray.getComboCodigos());
                    this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());
                }
                break;
            case "Eliminar":

                GUIPaqueteTuristico.enviarMensaje(this.paqueteArray.delete(this.panelPaquete.getPaquete()));
                this.panelPaquete.limpiar();
                this.panelPaquete.setCbPaquetesRegistrados(this.paqueteArray.getComboCodigos());
                this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());

                break;
            case "Reporte":
                this.guiReport = new GUIReport();
                this.guiReport.setDataTable(paqueteArray.getMatrizPaquetesDisponibles(), PaqueteTuristico.TBL_LABELS);
                this.guiReport.setVisible(true);
                
                break;
            case "Limpiar":
                this.panelPaquete.limpiar();
                this.panelPaquete.setlbCodigo(this.paqueteArray.getCodigosPaquetes());

                break;

            case "cbxCodigos":
                PaqueteTuristico paquete = this.paqueteArray.search(Integer.parseInt(this.panelPaquete.getCbCodigo()));
                if (paquete != null) {
                    this.panelPaquete.setPaquete(paquete);
                }
                break;
            case "Salir":
                this.guiPaquete.dispose();
                break;

        }
    }

}
