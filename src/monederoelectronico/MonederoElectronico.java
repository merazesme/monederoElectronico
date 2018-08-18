/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monederoelectronico;

import controlador.CambiaPanel;
import controlador.controlBase;
import controlador.controlLogin;
import javax.swing.ImageIcon;
import modelo.ModeloLogin;
import vista.vistaBase;
import vista.vistaLogin;

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
        vistaLogin vistaLogin = new vistaLogin();
        controlBase control = new controlBase(vista, 0);
         ModeloLogin modelo = new ModeloLogin();
        controlLogin controlLogin = new controlLogin(vistaLogin, modelo);
        control.iniciarVista();
        CambiaPanel cambio = new CambiaPanel(vista.panelBase, vistaLogin);
        controlLogin.iniciarVista();
        
//        vista.setIconImage(new ImageIcon("../imagenes/logo100px.png").getImage());
    }
    
}
