/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.modeloSaldo; 
import vista.vistaMovimientosCargo;
/**
 *
 * @author Fabiola Paez
 */
public class controlSaldo implements ActionListener, KeyListener,MouseListener{
    private vistaMovimientosCargo vista; 
    private modeloSaldo modelo; 
    
    public controlSaldo(vistaMovimientosCargo vista, modeloSaldo modelo)
    {
        this.vista=vista; 
        this.modelo=modelo; 
        this.vista.txtCliente.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.txtCliente.addKeyListener(this);
        this.vista.tabla.addMouseListener(this);
    }
    public void iniciarVista() // Muestra la vista 
    {   this.vista.tabla.setModel(modelo.saldoConsultar()); 
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegresar) {
            vista.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println(""+vista.txtCliente.getText());
        vista.tabla.setModel(modelo.Buscador(String.valueOf(vista.txtCliente.getText()))); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(vista.tabla == e.getSource())
        {   int fila = vista.tabla.rowAtPoint(e.getPoint()); 
            if( fila > -1)
            {   
                vista.lblClienteN.setText(
                "Cliente: "+String.valueOf(vista.tabla.getValueAt(fila, 1))
                +" "+String.valueOf(vista.tabla.getValueAt(fila, 2))
                +"              Puntos: "+String.valueOf(vista.tabla.getValueAt(fila, 3)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }
}
