/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaCargos;
import vista.vistaPremios;

/**
 *
 * @author Holi
 */
public class controlPremios implements ActionListener{
    
    vistaPremios vista;
    
    public controlPremios(vistaPremios vista)
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
