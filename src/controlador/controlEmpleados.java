/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaEmpleados;

/**
 *
 * @author Holi
 */
public class controlEmpleados implements ActionListener{
    
    vistaEmpleados vista;
    
    public controlEmpleados(vistaEmpleados vista)
    {
        this.vista=vista;
        this.vista.btnAgregar.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
