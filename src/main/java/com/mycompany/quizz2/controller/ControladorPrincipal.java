/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.controller;

import com.mycompany.quizz2.model.ArrayCotizacion;
import com.mycompany.quizz2.model.ArrayPaqueteTuristico;
import com.mycompany.quizz2.model.PaqueteTuristico;
import com.mycompany.quizz2.view.GUIMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class ControladorPrincipal implements ActionListener {

    private GUIMain guiMain;
    private ControladorPaqueteTuristico controladorPaquete;
    private ArrayPaqueteTuristico paqueteArray;
    private ArrayCotizacion arrayCotizacion;

    public ControladorPrincipal() {
        this.guiMain = new GUIMain();//Crear la instancia
        this.guiMain.listen(this);//Hacer escuchar los botones
        this.paqueteArray = new ArrayPaqueteTuristico();
        this.arrayCotizacion = new ArrayCotizacion();
        this.guiMain.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salir":
                System.exit(0);
                break;
            case "Paquete":
                ControladorPaqueteTuristico controladorPaquete = new ControladorPaqueteTuristico(paqueteArray);
                break;
            case "Cotizacion":
                ControladorCotizacion controladorCotizacion = new ControladorCotizacion(arrayCotizacion,paqueteArray);
                break;

        }
    }

}
