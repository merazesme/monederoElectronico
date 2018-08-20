/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloAbonos;
import vista.vistaAbonos;
import vista.vistaCargos;

/**
 *
 * @author Holi
 */
public class controlAbonos implements ActionListener{
    modeloAbonos modelo;
    vistaAbonos vista;
    
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
    }
    
    public void limpiar()
    {
        this.vista.txt_Importe.setText("");
        this.vista.txt_NumTicket.setText("");
        this.vista.txt_Numcliente.setText("");
        this.vista.jlb_Puntos.setText("");
    }
    
    public String validacionCamposVacios() // Verifica que no haya campos vacios 
    {   if(vista.txt_Importe.getText().isEmpty() || vista.txt_NumTicket.getText().isEmpty() || vista.txt_Numcliente.getText().isEmpty())
            return "Favor de llenar todos los campos"; 
        else return null;
    }
    
    public static boolean ValidarImporte(String importe){
	try {
		Double.parseDouble(importe);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double importe=0.0;
        double puntos=0.0;
        if(vista.txt_Importe == e.getSource()) {
            if(ValidarImporte(vista.txt_Importe.getText())==true) {
                importe = Double.parseDouble(vista.txt_Importe.getText());
                puntos = importe*10;
                vista.jlb_Puntos.setText(String.valueOf(puntos));
            }
            else {
                JOptionPane.showMessageDialog(null, "Favor de ingresar numeros");
                vista.txt_Importe.setText("");
            }
        }
        if(vista.btn_Abonar == e.getSource())
        {  
            if(validacionCamposVacios()==null)
            {    
            }
            else
               JOptionPane.showMessageDialog(null, ""+validacionCamposVacios());
        }
        if(vista.btn_Movimientos == e.getSource())
        {  
            JOptionPane.showMessageDialog(null, "Campos llenos");
        }
    }
}
