/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloMovimientosAbono;
import vista.vistaMovimientosCargo;

/**
 *
 * @author Adriana
 */
public class controlMovimientosAbono implements ActionListener {
    modeloMovimientosAbono modelo;
    vistaMovimientosCargo vista;
    
    public controlMovimientosAbono(vistaMovimientosCargo vista, modeloMovimientosAbono modelo)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnRegresar.addActionListener(this);
        this.vista.txtCliente.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        vista.tabla.setModel(modelo.MovimientosAbono(vista.txtCliente.getText()));
    }
    
    public void limpiar() {
        //Limpiar campos
        vista.tabla.setModel(modelo.MovimientosAbono(vista.txtCliente.getText()));
        vista.txtCliente.setText("");
        int a =modelo.MovimientosAbono(vista.txtCliente.getText()).getRowCount()-1;
        for(int i=0; i<a;i++){
            modelo.MovimientosAbono(vista.txtCliente.getText()).removeRow(i);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.txtCliente == e.getSource())
        {  
            try {
                if(vista.txtCliente.getText().equals(""))
                {
                    limpiar();
                    JOptionPane.showMessageDialog(null, "No se ha ingresado un Cliente", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if(modelo.validarCliente(Integer.parseInt(vista.txtCliente.getText()))==true) {
                        vista.tabla.setModel(modelo.MovimientosAbono(vista.txtCliente.getText()));
                        if (this.vista.tabla.getRowCount() == 0 && this.vista.tabla.getSelectedRow() == -1) {
                            JOptionPane.showMessageDialog(null, "Este cliente no tiene ningun movimiento", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                            limpiar();
                        }
                    }
                    else {
                        limpiar();
                    }
                }
            }catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        if(vista.btnRegresar == e.getSource())
        {  
            vista.dispose();
        }
    }
}
