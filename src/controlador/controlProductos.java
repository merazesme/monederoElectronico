/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaCargos;
import vista.vistaProductos;

/**
 *
 * @author Holi
 */
public class controlProductos implements ActionListener{
    
    vistaProductos vista;
    
    public controlProductos(vistaProductos vista)
    {
        this.vista=vista;
        this.vista.btnFinalizar.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
