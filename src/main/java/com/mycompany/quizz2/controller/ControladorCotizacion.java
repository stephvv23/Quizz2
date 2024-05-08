/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizz2.controller;

import com.mycompany.quizz2.model.ArrayCotizacion;
import com.mycompany.quizz2.model.ArrayPaqueteTuristico;
import com.mycompany.quizz2.model.Cotizacion;
import com.mycompany.quizz2.model.PaqueteTuristico;
import com.mycompany.quizz2.view.DataPanelBotones;
import com.mycompany.quizz2.view.DataPanelCotizacion;
import com.mycompany.quizz2.view.GUICotizacion;
import com.mycompany.quizz2.view.GUIPaqueteTuristico;
import com.mycompany.quizz2.view.GUIReport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Stephanie
 */
public class ControladorCotizacion implements ActionListener, MouseListener {

    private GUICotizacion guiCotizacion;
    private DataPanelCotizacion panelCotizacion;
    private DataPanelBotones dataPanelBotones;
    private ArrayCotizacion arrayCotizacion;
    private ArrayPaqueteTuristico arrayPaquete;
    private GUIReport guiReport;

    public ControladorCotizacion(ArrayCotizacion arrayCotizaciones, ArrayPaqueteTuristico arrayPaquetes) {
        this.guiCotizacion = new GUICotizacion();

        this.arrayCotizacion = arrayCotizaciones;
        this.arrayPaquete = arrayPaquetes;

        this.dataPanelBotones = this.guiCotizacion.getDataPanelBotones1();
        this.dataPanelBotones.listen(this);

        this.panelCotizacion = this.guiCotizacion.getDataPanelCotizacion1();
        this.panelCotizacion.setlbCodigo(arrayCotizacion.getlbCodigo());
        this.panelCotizacion.setCbCotizacionesRegistradas(arrayCotizacion.getCodigoCombo());
        this.panelCotizacion.setTblPaquetesDisponibles(arrayPaquete.getMatrizPaquetesDisponibles(), PaqueteTuristico.TBL_LABELS);

        this.panelCotizacion.listenAction(this);
        this.panelCotizacion.listenMouse(this);

        this.guiCotizacion.setVisible(true);
    }

    public boolean validarCotizacion(Cotizacion cotizacionValidar) {
        if (cotizacionValidar.getPrecioTotal() <= 0) {
            GUIPaqueteTuristico.enviarMensaje("Seleccione algun paquete");
            return false;
        }
        return true;

    }

    public void limpiarGUI() {
        this.panelCotizacion.setlbCodigo(arrayCotizacion.getlbCodigo());
        this.panelCotizacion.setCbCotizacionesRegistradas(arrayCotizacion.getCodigoCombo());
        this.arrayPaquete.limpiarListaSeleccionados();
        this.panelCotizacion.setTblPatequesSeleccionados(arrayPaquete.getMatrizPaquetesSeleccionados(), PaqueteTuristico.TBL_LABELS);
        this.panelCotizacion.setPrecio(arrayPaquete.getPrecioTotal());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Añadir":
                Cotizacion cotizacionAux = this.panelCotizacion.getCotizacion();
                cotizacionAux.setPaquetes(arrayPaquete.getListaPaquetesSeleccionados());
                cotizacionAux.setPrecioTotal(arrayPaquete.getPrecioTotal());

                if (validarCotizacion(cotizacionAux)) {
                    GUIPaqueteTuristico.enviarMensaje(arrayCotizacion.add(cotizacionAux));
                    this.limpiarGUI();
                }

                break;
            case "Editar":
                Cotizacion cotizacionEdit = this.panelCotizacion.getCotizacion();
                cotizacionEdit.setPaquetes(arrayPaquete.getListaPaquetesSeleccionados());
                cotizacionEdit.setPrecioTotal(arrayPaquete.getPrecioTotal());

                if (validarCotizacion(cotizacionEdit)) {
                    GUIPaqueteTuristico.enviarMensaje(arrayCotizacion.edit(cotizacionEdit));
                }
                break;
            case "Eliminar":
                Cotizacion cotizacionDelete = this.panelCotizacion.getCotizacion();
                cotizacionDelete.setPaquetes(arrayPaquete.getListaPaquetesSeleccionados());
                cotizacionDelete.setPrecioTotal(arrayPaquete.getPrecioTotal());

                if (validarCotizacion(cotizacionDelete)) {
                    GUIPaqueteTuristico.enviarMensaje(arrayCotizacion.delete(cotizacionDelete));

                    this.limpiarGUI();

                }
                break;
            case "Reporte":
                this.guiReport = new GUIReport();
                this.guiReport.setDataTable(arrayCotizacion.getMatrizCotizaciones(), Cotizacion.TBL_LABELS);
                this.guiReport.setVisible(true);

                break;
            case "Salir":
                this.guiCotizacion.dispose();
                break;
            case "Limpiar":
                this.limpiarGUI();

                break;
            case "comboBoxCotizaciones":
                Cotizacion cotizacion = this.arrayCotizacion.search(this.panelCotizacion.getCbCodigoSeleceted());
                if (cotizacion != null) {
                    this.panelCotizacion.setCotizacion(cotizacion);
                    this.arrayPaquete.setListaPaquetesSeleccionados(cotizacion.getPaquetes());
                    this.panelCotizacion.setTblPatequesSeleccionados(arrayPaquete.getMatrizPaquetesSeleccionados(), PaqueteTuristico.TBL_LABELS);

                }

                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().toString().equals(this.panelCotizacion.getTblPaquetesDisponibles())) {
            //int cantidadPasajeros, int codigo, String destino, double precio, int diasViaje

            this.arrayPaquete.addPaquetesSeleccionados(new PaqueteTuristico(Integer.parseInt(this.panelCotizacion.getDataRowTbDisp()[1]),
                    Integer.parseInt(this.panelCotizacion.getDataRowTbDisp()[0]),
                    this.panelCotizacion.getDataRowTbDisp()[2],
                    Double.parseDouble(this.panelCotizacion.getDataRowTbDisp()[3]),
                    Integer.parseInt(this.panelCotizacion.getDataRowTbDisp()[4])));

            this.panelCotizacion.setPrecio(arrayPaquete.getPrecioTotal());

            this.panelCotizacion.setTblPatequesSeleccionados(arrayPaquete.getMatrizPaquetesSeleccionados(), PaqueteTuristico.TBL_LABELS);

        }

        if (e.getSource().toString().equals(this.panelCotizacion.getTblPaquetesSeleccionados())) {

            this.arrayPaquete.deletePaqueteSeleccionado(this.panelCotizacion.getRowSelected());

            this.panelCotizacion.setPrecio(arrayPaquete.getPrecioTotal());

            this.panelCotizacion.setTblPatequesSeleccionados(arrayPaquete.getMatrizPaquetesSeleccionados(), PaqueteTuristico.TBL_LABELS);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
