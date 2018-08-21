/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import vista.vistaCargos;
import vista.vistaClientes;
import modelo.modeloCliente; 
/**
 *
 * @author Holi
 */
public class controlClientes implements ActionListener{
    private vistaClientes vista;
    private modeloCliente modelo; 
    //Permite acceder a funciones de la fecha.
    Calendar calendario = Calendar.getInstance();
    //Agarra el año en curso.
    int anioActual = calendario.get(Calendar.YEAR);
    //Agarra el mes en curso.
    int mesActual = calendario.get(Calendar.MONTH);
    //Agarra el dia en curso.
    int diaActual = calendario.get(Calendar.DAY_OF_MONTH);
    public controlClientes(vistaClientes vista, modeloCliente modelo)
    {   this.vista=vista;
        this.modelo=modelo;
        this.vista.btnMovimientos.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnSaldo.addActionListener(this);
        this.vista.RadioBtnFemenino.addActionListener(this);
        this.vista.RadioBtnMasculino.addActionListener(this);
    }
    public void limpiar()
    {   this.vista.txtNombre.setText("");
        this.vista.txtApellidos.setText("");
        this.vista.txtCorreo.setText("");
        this.vista.txtDireccion.setText("");
        this.vista.txtTelefono.setText("");
        this.vista.DateNacimineto.setCalendar(null); 
        this.vista.Genero.clearSelection();
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnAgregar == e.getSource())
        {   
            int mes=vista.DateNacimineto.getCalendar().get(Calendar.MONTH)+1; 
            String genero=""; 
            if(vista.RadioBtnFemenino.isSelected())
                genero="femenino";
            else if(vista.RadioBtnMasculino.isSelected())
                genero="masculino"; 
            int edad=anioActual-vista.DateNacimineto.getCalendar().get(Calendar.YEAR); 
            if(mes>=mesActual && vista.DateNacimineto.getCalendar().get(Calendar.DAY_OF_MONTH)>=diaActual)
                edad-=1;
            String fecha=vista.DateNacimineto.getCalendar().get(Calendar.YEAR)+"-"+mes+"-"+vista.DateNacimineto.getCalendar().get(Calendar.DAY_OF_MONTH); 
            System.out.println("Nombre: "+vista.txtNombre.getText()
                    +"\nApellidos: "+vista.txtApellidos.getText()
                    +"\nCorreo: "+vista.txtCorreo.getText()
                    +"\nTelefono: "+vista.txtTelefono.getText()
                    +"\nDireccion: "+vista.txtDireccion.getText()
                    +"\nFecha: "+fecha
                    +"\nGenero: "+genero
                    +"\nEdad: "+edad
            );
            if(modelo.agregarCliente(vista.txtNombre.getText(), vista.txtApellidos.getText(), vista.txtCorreo.getText(), vista.txtTelefono.getText(), fecha, vista.txtDireccion.getText(), genero, edad))
            {   JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
                limpiar(); 
            }
            else
                JOptionPane.showMessageDialog(null, "Error al insertar los datos");
        }
    }
}
