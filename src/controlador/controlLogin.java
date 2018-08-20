/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.ModeloLogin;
import vista.vistaBase;
import vista.vistaLogin;

/**
 *
 * @author Holi
 */
public class controlLogin implements ActionListener{
    
    vistaLogin vista;
    private ModeloLogin modelo;
    
    public controlLogin(vistaLogin vista, ModeloLogin modelo)
    {
        this.vista=vista;
        this.modelo = modelo;
        this.vista.entrar.addActionListener(this);
        this.vista.texto_usuario.addActionListener(this);
        this.vista.texto_contraseña.addActionListener(this);
        this.vista.entrar.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        Date fecha = new Date(); 
        //Fecha y hora
        vista.fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        Hora hora =  new Hora(vista.hora);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usu = vista.texto_usuario.getText();
        String contra = new String(vista.texto_contraseña.getPassword());
        
        if(this.vista.entrar == e.getSource() || this.vista.texto_usuario == e.getSource() || vista.texto_contraseña == e.getSource())
        {
            switch (modelo.ingresar(usu, contra))
            {
                case 1:
                    vistaBase vistaBase = new vistaBase();
                    controlBase controlBase = new controlBase(vistaBase);
                    controlBase.iniciarVista();
                    vistaBase.btnAbonos.setEnabled(true);
                    vistaBase.btnCargos.setEnabled(true);
                    vistaBase.btnCliente.setEnabled(true);
                    vistaBase.btnEmpleados.setEnabled(true);
                    vistaBase.btnRegalo.setEnabled(true);
                    this.vista.setVisible(false);
                    
                    break;
                case 2:
                    //Aqui nada nel pastel
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"USUARIO/CONTRASEÑA INCORRECTOS");
                    break;
                default:

                    break;
            }
        }
    }
}
