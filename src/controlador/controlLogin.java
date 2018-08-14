/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaBase;
import vista.vistaLogin;

/**
 *
 * @author Holi
 */
public class controlLogin implements ActionListener{
    
    vistaLogin vista;
    
    public controlLogin(vistaLogin vista)
    {
        this.vista=vista;
        this.vista.btnEntrar.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.vista.btnEntrar == e.getSource())
        {
            vistaBase vistaBase = new vistaBase();
            controlBase controlBase = new controlBase(vistaBase);
            controlBase.iniciarVista();
            vistaBase.btnAbonos.setEnabled(true);
            vistaBase.btnCargos.setEnabled(true);
            vistaBase.btnCliente.setEnabled(true);
            vistaBase.btnEmpleados.setEnabled(true);
            vistaBase.btnRegalo.setEnabled(true);
        }
    }
}
