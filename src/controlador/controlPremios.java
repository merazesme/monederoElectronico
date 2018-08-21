/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.modeloPremios;
import vista.vistaPremios;

/**
 *
 * @author Holi
 */
public class controlPremios implements ActionListener, MouseListener{
    
    vistaPremios vista;
    modeloPremios modelo;
    int idPremio;
    
    public controlPremios(vistaPremios vista, modeloPremios modelo, int sucursal)
    {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnanadir.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.tablaPremios.addMouseListener(this);
    }
    public void iniciarVista()
    {
        this.vista.setVisible(true);
        this.vista.tablaPremios.setModel(modelo.mostrarRegistrosTabla(Integer.parseInt(controlLogin.empleado[1])));
        this.vista.lblSucursal.setText("Sucursal no. "+controlLogin.empleado[1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //btn agregar
        try{
           if(this.vista.btnanadir == e.getSource())
            {
                if((Integer) this.vista.spnCantidad.getValue() <= 0)
                    throw new Exception();
                if(modelo.transaccionAgregar(this.vista.txtNombre.getText(), Integer.parseInt(this.vista.txtPuntos.getText()), (Integer) this.vista.spnCantidad.getValue(), (Integer.parseInt(controlLogin.empleado[1]))))
                {
                    JOptionPane.showMessageDialog(null, "Se ha registrado corectamente el producto");
                    this.vista.tablaPremios.setModel(modelo.mostrarRegistrosTabla((Integer.parseInt(controlLogin.empleado[1]))));
                }
                    
                
            } 
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Revise los campos.");
        }
        //btn editar
        try{
           if(this.vista.btnModificar == e.getSource())
            {
                if((Integer) this.vista.spnCantidad.getValue() <= 0)
                    throw new Exception();
                if(modelo.transaccionModificar(this.vista.txtNombre.getText(), Integer.parseInt(this.vista.txtPuntos.getText()), (Integer) this.vista.spnCantidad.getValue(), (Integer.parseInt(controlLogin.empleado[1])), idPremio))
                {
                    JOptionPane.showMessageDialog(null, "Se ha modificado correctamente el producto");
                    this.vista.tablaPremios.setModel(modelo.mostrarRegistrosTabla((Integer.parseInt(controlLogin.empleado[1]))));
                }
                    
                
            } 
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Revise los campos.");
        }
        
        //btn eliminar
        try
        {
           if(this.vista.btnEliminar == e.getSource())
            {
                int respuesta = JOptionPane.showConfirmDialog(null, "Este producto será eliminado de todas la sucursales.\n ¿Continuar?");
                switch (respuesta)
                {
                    case 0:
                        if(modelo.transaccionEliminar(idPremio))
                        {
                            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el producto");
                            this.vista.tablaPremios.setModel(modelo.mostrarRegistrosTabla((Integer.parseInt(controlLogin.empleado[1]))));
                        }
                        break;
                }
            } 
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Revise los campos.");
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.vista.tablaPremios == e.getSource()){
             int fila = vista.tablaPremios.rowAtPoint(e.getPoint());
             if(fila > -1){
                 //Guardar datos de la tabla a los JTextField
                 idPremio = Integer.parseInt((String.valueOf(vista.tablaPremios.getValueAt(fila, 0))));
                 this.vista.txtNombre.setText(String.valueOf(vista.tablaPremios.getValueAt(fila, 1)));
                 this.vista.txtPuntos.setText(String.valueOf(vista.tablaPremios.getValueAt(fila, 2)));
                 this.vista.spnCantidad.setValue(Integer.parseInt((String.valueOf(vista.tablaPremios.getValueAt(fila, 4)))));
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
}
