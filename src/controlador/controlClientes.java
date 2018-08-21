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
import vista.vistaClientes;
import modelo.modeloCliente; 
import modelo.modeloSaldo; 
import modelo.modeloMovimientosCargo;
import vista.vistaMovimientos;
import vista.vistaMovimientosCargo;

/**
 *
 * @author Holi
 */
public class controlClientes implements ActionListener{
    private vistaClientes vista;
    private modeloCliente modelo; 
    int genero=0; 
    String fecha=""; 
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
        vista.lblSucursal.setText("Sucursal no."+controlLogin.empleado[1]);
       // System.out.println("Año: "+anioActual);
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
     public String validacionCamposVacios() // Valida que los campos no esten vacios
    {   if(vista.txtNombre.getText().isEmpty() || vista.txtApellidos.getText().isEmpty()
            || vista.txtTelefono.getText().isEmpty() || vista.txtDireccion.getText().isEmpty()
            || vista.txtCorreo.getText().isEmpty() || genero ==0 )
            return "Favor de llenar todos los campos"; 
        else 
            return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnAgregar == e.getSource())
        {   
//            if(validacionCamposVacios()==null)
//            {
                int mes=vista.DateNacimineto.getCalendar().get(Calendar.MONTH)+1; 
                if(vista.RadioBtnFemenino.isSelected())
                    genero=1;
                else if(vista.RadioBtnMasculino.isSelected())
                    genero=2; 
                int edad=anioActual-vista.DateNacimineto.getCalendar().get(Calendar.YEAR); 
                if(mes>=mesActual && vista.DateNacimineto.getCalendar().get(Calendar.DAY_OF_MONTH)>=diaActual)
                    edad-=1;
                fecha=vista.DateNacimineto.getCalendar().get(Calendar.YEAR)+"-"+mes+"-"+vista.DateNacimineto.getCalendar().get(Calendar.DAY_OF_MONTH); 
                int inserta = modelo.agregarCliente(vista.txtNombre.getText(), vista.txtApellidos.getText(), vista.txtCorreo.getText(), vista.txtTelefono.getText(), fecha, vista.txtDireccion.getText(), genero, edad); 
                if(inserta >= 0)
                {   JOptionPane.showMessageDialog(null, "Registro agregado exitosamente\n       ID del cliente: "+inserta);
                    limpiar(); 
                }
                else
                    JOptionPane.showMessageDialog(null, "Error al insertar los datos");
//            }
//            else 
//                JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
        }
        else if(vista.btnMovimientos == e.getSource())
        {
            modeloMovimientosCargo m = new modeloMovimientosCargo();
            vistaMovimientos v = new vistaMovimientos();
            controlMovimientosCliente c = new controlMovimientosCliente(v, m);
            c.iniciarvista(); 
        }
        else if(vista.btnSaldo == e.getSource())
        {
            vistaMovimientosCargo vistaFrame = new vistaMovimientosCargo(); 
            modeloSaldo modelos = new modeloSaldo(); 
            controlSaldo control = new controlSaldo(vistaFrame,modelos); 
            control.iniciarVista();
        }
    }
}
