/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloMovimientosCargo;
import vista.vistaCargos;
import vista.vistaMovimientosCargo;

/**
 *
 * @author ITZEL
 */
public class controladorMovimientosCargo implements ActionListener{
    private vistaMovimientosCargo vista;
    private modeloMovimientosCargo modelo;
    private vistaCargos vCargos;
    
    public controladorMovimientosCargo(vistaMovimientosCargo vista, modeloMovimientosCargo modelo, vistaCargos vCargos)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vCargos=vCargos;
        this.vista.btnRegresar.addActionListener(this);
    }

    public void iniciarvista(){
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        if(!vCargos.txtCliente.getText().equals("")){
            vista.txtCliente.setText(vCargos.txtCliente.getText());
            vista.lblClienteN.setText(vCargos.lblClienteN.getText());
            DefaultTableModel model=modelo.productosConsultar(vista.txtCliente.getText());
            if(model!=null)
                vista.tabla.setModel(model);
            else
                JOptionPane.showMessageDialog(null, "No se han encontrado movimientos", "¡Atención!", JOptionPane.ERROR_MESSAGE);

        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegresar) {
            vista.dispose();
        }
    }
}
