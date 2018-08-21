/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloMovimientosCargo;
import vista.vistaCargos;
import vista.vistaMovimientos;

/**
 *
 * @author Fabiola Paez
 */
public class controlMovimientosCliente implements ActionListener, KeyListener{
    private vistaMovimientos vista;
    private modeloMovimientosCargo modelo;
    String tipo; 
    public controlMovimientosCliente(vistaMovimientos vista, modeloMovimientosCargo modelo)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnRegresar.addActionListener(this);
        this.vista.txtCliente.addKeyListener(this);
    }

    public void iniciarvista(){
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegresar) {
            vista.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == vista.txtCliente){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                if(!vista.txtCliente.getText().equals("")){
                    tipo=vista.tipoT.getSelectedItem().toString(); 
                    DefaultTableModel model; 
                    if(tipo == "Cargos")
                        model=modelo.clienteCargos(vista.txtCliente.getText());
                    else 
                        model=modelo.clienteAbonos(vista.txtCliente.getText());
                    if(model!=null){
                        vista.tabla.setModel(model);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se han encontrado movimientos", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha ingresado un Cliente", "¡Atención!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
