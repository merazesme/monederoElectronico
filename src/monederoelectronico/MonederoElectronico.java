/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monederoelectronico;

import controlador.CambiaPanel;
import controlador.controlBase;
import controlador.controlElegirSucursal;
import controlador.controlLogin;
import javax.swing.ImageIcon;
import modelo.ModeloLogin;
import vista.elegirsucursal;
import vista.vistaBase;
import vista.vistaDefault;
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
        elegirsucursal vistasu = new elegirsucursal();
        controlElegirSucursal cs = new controlElegirSucursal(vistasu, 0);
        cs.iniciarVista();
        
//        vista.setIconImage(new ImageIcon("../imagenes/logo100px.png").getImage());
    }
    
}
