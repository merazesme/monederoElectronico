/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monederoelectronico;

import controlador.controlBase;
import javax.swing.ImageIcon;
import vista.vistaBase;

/**
 *
 * @author Holi
 */
public class MonederoElectronico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vistaBase vista = new vistaBase();
        controlBase control = new controlBase(vista);
        control.iniciarVista();
//        vista.setIconImage(new ImageIcon("../imagenes/logo100px.png").getImage());
    }
    
}
