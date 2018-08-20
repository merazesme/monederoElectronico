/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;
import vista.vistaBase;
import vista.vistaDefault;
import vista.vistaLogin;

/**
 *
 * @author Holi
 */
public class controlLogin implements ActionListener{
    
    vistaLogin vista;
    private ModeloLogin modelo;
    private vistaBase base; 
    private vistaDefault vdefault; 
    public controlLogin(vistaLogin vista, ModeloLogin modelo,vistaBase base,vistaDefault vdefault)
    {
        this.vista=vista;
        this.modelo = modelo;
        this.base=base; 
        this.vdefault=vdefault; 
        this.vista.entrar.addActionListener(this);
        this.vista.texto_usuario.addActionListener(this);
        this.vista.texto_contraseña.addActionListener(this);
        this.vista.entrar.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usu = vista.texto_usuario.getText();
        String contra = new String(vista.texto_contraseña.getPassword());
        
        if(this.vista.entrar == e.getSource() || this.vista.texto_usuario == e.getSource() || vista.texto_contraseña == e.getSource())
        {
            String [] resultado = new String [2];
            resultado = modelo.ingresar(usu, contra);
            if(resultado[0].equals("1")) {
//                    vistaBase vistaBase = new vistaBase();
//                    controlBase controlBase = new controlBase(vistaBase, Integer.parseInt(resultado[1]));
//                    controlBase.iniciarVista();
                    CambiaPanel cambio = new CambiaPanel(base.panelBase, this.vdefault);
                    base.btnAbonos.setEnabled(true);
                    base.btnCargos.setEnabled(true);
                    base.btnCliente.setEnabled(true);
                    base.btnEmpleados.setEnabled(true);
                    base.btnRegalo.setEnabled(true);
            }
            else if(resultado[0].equals("3"))
            {
                JOptionPane.showMessageDialog(null,"USUARIO/CONTRASEÑA INCORRECTOS");
            }
        }
    }
}
