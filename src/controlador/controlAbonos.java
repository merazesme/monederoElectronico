/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloAbonos;
import modelo.modeloMovimientosAbono;
import vista.vistaAbonos;
import vista.vistaCargos;
import vista.vistaMovimientosCargo;

/**
 *
 * @author Holi
 */
public class controlAbonos implements ActionListener {
    modeloAbonos modelo;
    vistaAbonos vista;
    String idEmpleado= controlLogin.empleado[2];
    
    public controlAbonos(vistaAbonos vista, modeloAbonos modelo)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btn_Abonar.addActionListener(this);
        this.vista.btn_Movimientos.addActionListener(this);
        this.vista.txt_Importe.addActionListener(this);
        this.vista.txt_NumTicket.addActionListener(this);
        this.vista.txt_Numcliente.addActionListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        limpiar();
        Date fecha = new Date();  
        //Fecha y hora
        vista.fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        Hora hora =  new Hora(vista.hora);
        vista.lblSucursal.setText("Sucursal no."+controlLogin.empleado[1]);
    }
    
    public void limpiar()
    {
        this.vista.txt_Importe.setText("");
        this.vista.txt_NumTicket.setText("");
        this.vista.txt_Numcliente.setText("");
        this.vista.jlb_Puntos.setText("");
    }
    
    public String validacionCamposVacios() // Verifica que no haya campos vacios 
    {   if(vista.txt_Importe.getText().isEmpty() || vista.txt_NumTicket.getText().isEmpty() || vista.txt_Importe.getText().isEmpty() || vista.jlb_Puntos.getText().isEmpty())
            return "Favor de llenar todos los campos"; 
        else return null;
    }
    
    public static boolean ValidarImporte(String importe){
	try {
		Double.parseDouble(importe);
		return true;
	} catch (NumberFormatException e){
		return false;
	}
    }
    
    public static boolean ValidarNumeros(String NumCliente, String NumTicket) {
	try {
                Integer.parseInt(NumTicket);
                Integer.parseInt(NumCliente);
		return true;
	} catch (NumberFormatException e){
		return false;
	}
    }
    
    public String formatoFecha(String fecha){
        System.out.println("");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dates = null;
        try {
            dates = format.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(controlCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dates);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double importe=0.0;
        double puntos=0.0;
        //Validacion al ingresar Importe
        if(vista.txt_Importe == e.getSource()) 
        {
            try {
                if(ValidarImporte(vista.txt_Importe.getText())==true) {
                    importe = Double.parseDouble(vista.txt_Importe.getText());
                    puntos = importe*0.10;
                    int entero = (int)puntos;
                    vista.jlb_Puntos.setText(String.valueOf(entero));
                }
                else {
                    vista.txt_Importe.setText("");
                    vista.jlb_Puntos.setText("");
                    JOptionPane.showMessageDialog(null, "Solo números");
                }
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en al generar puntos");
            } 
        }
        //Boton Abonar
        if(vista.btn_Abonar == e.getSource())
        {  
            try {
                if(validacionCamposVacios()==null)
                {  
                    if(ValidarNumeros(vista.txt_NumTicket.getText(), vista.txt_Numcliente.getText())==true) {
                        if(modelo.insertarAbono(formatoFecha(vista.fecha.getText()), 
                        Integer.parseInt(vista.jlb_Puntos.getText()),
                        Double.parseDouble(vista.txt_Importe.getText()), 
                        Integer.parseInt(vista.txt_NumTicket.getText()), 
                        Integer.parseInt(vista.txt_Numcliente.getText()), 
                        Integer.parseInt(idEmpleado))) {
                            JOptionPane.showMessageDialog(null, "Abono realizo exitosamente");
                            limpiar();
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Favor de ingresar puros numeros");
                }
            else
               JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en el proceso de abonar");
            }
        }
        //Boton Movimientos
        if(vista.btn_Movimientos == e.getSource())
        {  
            try {
                modeloMovimientosAbono m = new modeloMovimientosAbono();
            vistaMovimientosCargo v = new vistaMovimientosCargo();
            controlMovimientosAbono c = new controlMovimientosAbono(v, m);
            c.iniciarVista(); 
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puedo abrir movimientos");
            }
        }
    }
}
