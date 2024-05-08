/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.quizz2.view;

import com.mycompany.quizz2.model.Cotizacion;
import com.mycompany.quizz2.model.PaqueteTuristico;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class DataPanelCotizacion extends javax.swing.JPanel {

    /**
     * Creates new form DataPanelCotizacion
     */
    public DataPanelCotizacion() {
        initComponents();
    }

    public String[] getDataRowTbDisp() {
        String[] datos = new String[this.tblPaquetesDisponibles.getColumnCount()];
        int rowSelected = this.tblPaquetesDisponibles.getSelectedRow();
        for (int i = 0; i < this.tblPaquetesDisponibles.getColumnCount(); i++) {
            datos[i] = this.tblPaquetesDisponibles.getValueAt(rowSelected, i).toString();
        }
        return datos;
    }

    public int getRowSelected() {
        return this.tblPaquetesSeleccionados.getSelectedRow();

    }
    
    public int getCbCodigoSeleceted(){
        try{
           return Integer.parseInt(this.cbxCotizacionesRegistradas.getSelectedItem().toString());
        }catch(NumberFormatException e){
            System.out.print("Seleccione un codigo, por favor");
        }
         return 0;
    }

    public String getTblPaquetesDisponibles() {
        return tblPaquetesDisponibles.toString();
    }

    public String getTblPaquetesSeleccionados() {
        return tblPaquetesSeleccionados.toString();
    }

    public void setPrecio(double precio) {
        this.lbPrecioCotizacion.setText(Double.toString(precio));
    }

    public void listenAction(ActionListener controller) {
        this.cbxCotizacionesRegistradas.addActionListener(controller);
    }

    public void listenMouse(MouseListener controller) {
        this.tblPaquetesDisponibles.addMouseListener(controller);
        this.tblPaquetesSeleccionados.addMouseListener(controller);
    }

    public void setlbCodigo(int codigoCotizacion) {
        this.lbCodigoCotizacion.setText(String.valueOf(codigoCotizacion));
    }

    //ArrayList<PaqueteTuristico> paquetes, int codigo
    public Cotizacion getCotizacion() {
        return new Cotizacion(Integer.parseInt(this.lbCodigoCotizacion.getText()));
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.lbCodigoCotizacion.setText(Integer.toString(cotizacion.getCodigo()));
        this.lbPrecioCotizacion.setText(Double.toString(cotizacion.getPrecioTotal()));
        this.setTblPatequesSeleccionados(cotizacion.getMatrizPaquetesVector(), PaqueteTuristico.TBL_LABELS);
    }

    public void limpiar() {
        this.lbPrecioCotizacion.setText("0");
    }

    public void setCbCotizacionesRegistradas(String[] idCotizaciones) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(idCotizaciones);
        model.insertElementAt("Seleccione", 0);
        this.cbxCotizacionesRegistradas.setModel(model);
    }

    public void setTblPaquetesDisponibles(String[][] data, String[] title) {
        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblPaquetesDisponibles.setModel(model);
        this.jScrollPane1.setViewportView(this.tblPaquetesDisponibles);
    }

    public void setTblPatequesSeleccionados(String[][] data, String[] title) {
        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblPaquetesSeleccionados.setModel(model);
        this.jScrollPane2.setViewportView(this.tblPaquetesSeleccionados);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaquetesDisponibles = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaquetesSeleccionados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbPrecioCotizacion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbCodigoCotizacion = new javax.swing.JLabel();
        cbxCotizacionesRegistradas = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Realice una cotizacion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Paquetes disponibles");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblPaquetesDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPaquetesDisponibles);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Paquetes seleccionados");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblPaquetesSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPaquetesSeleccionados);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Precio");

        lbPrecioCotizacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPrecioCotizacion.setText("0000");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Codigo cotizacion");

        lbCodigoCotizacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCodigoCotizacion.setText("0000");

        cbxCotizacionesRegistradas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCotizacionesRegistradas.setActionCommand("comboBoxCotizaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(53, 53, 53)
                                .addComponent(cbxCotizacionesRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(lbCodigoCotizacion))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbPrecioCotizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel3))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cbxCotizacionesRegistradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCodigoCotizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbPrecioCotizacion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCotizacionesRegistradas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigoCotizacion;
    private javax.swing.JLabel lbPrecioCotizacion;
    private javax.swing.JTable tblPaquetesDisponibles;
    private javax.swing.JTable tblPaquetesSeleccionados;
    // End of variables declaration//GEN-END:variables
}
