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
import vista.vistaMovimientosCargo;

/**
 *
 * @author ITZEL
 */
public class controladorMovimientosCargo implements ActionListener, KeyListener{
    private vistaMovimientosCargo vista;
    private modeloMovimientosCargo modelo;
    private vistaCargos vCargos;
    
    public controladorMovimientosCargo(vistaMovimientosCargo vista, modeloMovimientosCargo modelo, vistaCargos vCargos)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vCargos=vCargos;
        this.vista.btnRegresar.addActionListener(this);
        this.vista.txtCliente.addKeyListener(this);
    }

    public void iniciarvista()
    {
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        if(!vCargos.txtCliente.getText().equals("")){
            vista.txtCliente.setText(vCargos.txtCliente.getText());
            vista.lblClienteN.setText(vCargos.lblClienteN.getText());
            DefaultTableModel model=modelo.productosConsultar(vista.txtCliente.getText());
            if(model!=null){
                vista.tabla.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null, "No se han encontrado movimientos", "¡Atención!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
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
        if(e.getSource() == vista.txtCliente)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                if(!vista.txtCliente.getText().equals(""))
                {
                    DefaultTableModel model=modelo.productosConsultar(vista.txtCliente.getText());
                    String [] p = modelo.nombreCliente(vista.txtCliente.getText());
                    if(model!=null){
                        vista.tabla.setModel(model);
                        vista.lblClienteN.setText(p[0]+" "+p[1]);
                    }
                    else
                    {
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
