/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.quizz2.view;

import com.mycompany.quizz2.model.PaqueteTuristico;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuario
 */
public class DataPanelPaquete extends javax.swing.JPanel {

    /**
     * Creates new form DataPanelPaquete
     */
    public DataPanelPaquete() {
        initComponents();
    }

    public String getCbCodigo(){
        return this.cbxPaquetesRegistrados.getSelectedItem().toString();
    }
    
    public void listenCbPaquetesRegistrados(ActionListener controller) {
        this.cbxPaquetesRegistrados.addActionListener(controller);
    }

    public void setlbCodigo(int codigoPaquete) {
        this.lbCodigoPaquete.setText(String.valueOf(codigoPaquete));
    }

    public PaqueteTuristico getPaquete() {
        double precio = 0;
        try {
            precio = Double.parseDouble(this.txtPrecio.getText());

        } catch (NumberFormatException e) {
            GUIPaqueteTuristico.enviarMensaje("Valor incorrecto para precio");
        }
        return new PaqueteTuristico(Integer.parseInt(this.spCantidadPasajeros.getValue().toString()),
                    Integer.parseInt(this.lbCodigoPaquete.getText()),
                    this.cbxDestino.getSelectedItem().toString(),
                    precio,
                    Integer.parseInt(this.spDiasViaje.getValue().toString()));

    }

    public void setPaquete(PaqueteTuristico paqueteTuristico) {
        this.spCantidadPasajeros.setValue(paqueteTuristico.getCantidadPasajeros());
        this.lbCodigoPaquete.setText(Integer.toString(paqueteTuristico.getCodigo()));
        this.cbxDestino.setSelectedItem(paqueteTuristico.getDestino());
        this.txtPrecio.setText(Double.toString(paqueteTuristico.getPrecio()));
        this.spDiasViaje.setValue(paqueteTuristico.getDiasViaje());
    }

    public void limpiar() {
        this.spCantidadPasajeros.setValue(1);
        this.cbxDestino.setSelectedIndex(0);
        this.txtPrecio.setText("0");
        this.spDiasViaje.setValue(1);
    }

    public void setCbPaquetesRegistrados(String[] idPaquetes) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(idPaquetes);
        this.cbxPaquetesRegistrados.setModel(model);
    }

    public void setCBDestinos(String[] destinos) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(destinos);
        this.cbxDestino.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbCodigoPaquete = new javax.swing.JLabel();
        cbxDestino = new javax.swing.JComboBox<>();
        spCantidadPasajeros = new javax.swing.JSpinner();
        spDiasViaje = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cbxPaquetesRegistrados = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Destino");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Pasajeros");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Dias del viaje");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Registre un paquete de viaje...");

        lbCodigoPaquete.setText("0000");

        cbxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spCantidadPasajeros.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        spDiasViaje.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Precio");

        txtPrecio.setText("0");

        cbxPaquetesRegistrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPaquetesRegistrados.setActionCommand("cbxCodigos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(lbCodigoPaquete))
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spDiasViaje)
                            .addComponent(cbxDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spCantidadPasajeros)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(cbxPaquetesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxPaquetesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCodigoPaquete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spCantidadPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spDiasViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxPaquetesRegistrados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbCodigoPaquete;
    private javax.swing.JSpinner spCantidadPasajeros;
    private javax.swing.JSpinner spDiasViaje;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}