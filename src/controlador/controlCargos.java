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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCargos;
import modelo.modeloMovimientosCargo;
import vista.vistaCargos;
import vista.vistaMovimientosCargo;

/**
 *
 * @author Holi
 */
public class controlCargos implements ActionListener, MouseListener, KeyListener{
    
    private vistaCargos vista;
    private modeloCargos modelo;
    private String idS = "1", idE="1"; 
    
    private String idI;
    private int puntosP=-1, cantP;
    
    
    public controlCargos(vistaCargos vista, modeloCargos modelo)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnFinalizar.addActionListener(this);
        this.vista.tabla.addMouseListener(this);
        this.vista.txtCliente.addKeyListener(this);
        this.vista.btnMovimientos.addActionListener(this);
    }
    public void iniciarVista()
    {
        vista.lblSucursalN.setText(idS);
        Date fecha = new Date();   
        this.vista.setVisible(true);
        //Fecha y hora
        vista.lblFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        Hora hora =  new Hora(vista.lblHora);
        //Productos
        tabla();
    }

    public void tabla(){
        DefaultTableModel model=modelo.productosConsultar(idS);
        if(model!=null){
            vista.tabla.setModel(model);
            vista.tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            vista.tabla.getColumnModel().getColumn(3).setMinWidth(0);
            vista.tabla.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
            vista.tabla.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se han encontrado productos", "¡Atención!", JOptionPane.ERROR_MESSAGE);
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
        if(e.getSource()==vista.btnFinalizar){
            if(vista.lblPuntosN.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese el cliente", "¡Atención!", JOptionPane.ERROR_MESSAGE);
            }else{
                int puntos=Integer.parseInt(vista.lblPuntosN.getText());
                if(puntosP==-1){
                    JOptionPane.showMessageDialog(null, "Seleccione el premio a canjear", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                }else{
                    if(puntosP>puntos){
                        JOptionPane.showMessageDialog(null, "Los puntos no son suficientes para canjear ese producto", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(cantP==0){
                            JOptionPane.showMessageDialog(null, "No hay ese producto, escoge otro premio", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                        }else{
                            if(modelo.hacerCargo(formatoFecha(vista.lblFecha.getText()), vista.txtCliente.getText(), idE, idI, puntosP)){
                                JOptionPane.showMessageDialog(null, "Se ha guardado el cargo correctamente", "¡Atención!", JOptionPane.INFORMATION_MESSAGE);
                                String [] p = modelo.puntosAcumulados(vista.txtCliente.getText());
                                vista.lblPuntosN.setText(p[2]);
                                puntosP=-1;
                                idI="";
                                vista.lblProductoN.setText("");
                                tabla();
                            }
                        }
                    }
                }
               
            }
        }
        
        if(e.getSource() == vista.btnMovimientos){
            modeloMovimientosCargo m = new modeloMovimientosCargo();
            vistaMovimientosCargo v = new vistaMovimientosCargo();
            controladorMovimientosCargo c = new controladorMovimientosCargo(v, m, vista);
            c.iniciarvista();   
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(vista.tabla == e.getSource()){
            int fila = vista.tabla.rowAtPoint(e.getPoint());
            if(fila > -1){
                vista.lblProductoN.setText(String.valueOf(vista.tabla.getValueAt(fila, 1)));
                puntosP = Integer.parseInt(String.valueOf(vista.tabla.getValueAt(fila, 2)));
                idI = String.valueOf(vista.tabla.getValueAt(fila, 3));
                cantP = Integer.parseInt(String.valueOf(vista.tabla.getValueAt(fila, 4)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == vista.txtCliente){
              if(e.getKeyCode() == KeyEvent.VK_ENTER){
                  String [] p = modelo.puntosAcumulados(vista.txtCliente.getText());
                  if(p!=null){
                      vista.lblPuntosN.setText(p[2]);
                      vista.lblClienteN.setText(p[0]+" "+p[1]);
                  }
                  else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente", "¡Atención!", JOptionPane.ERROR_MESSAGE);
                  }
              }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
