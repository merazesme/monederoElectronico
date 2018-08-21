/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adriana
 */
public class modeloMovimientosAbono {
    private ConexionBD conexion = new ConexionBD();
    
    public boolean validarCliente(int idCliente) 
    {  
        int idC=0;
        
        Connection con = null;
        try {
            con = conexion.abrirConexion();
            con.setAutoCommit(false);
            
            Statement s = con.createStatement();
            ResultSet rs;
            
            //Compara si idCliente existe
            rs = s.executeQuery("SELECT idCliente FROM cliente "
                    + "WHERE idcliente="+idCliente+";"); 
            while (rs.next())
            {
                idC=rs.getInt (1);
            }
            if(idC==0)
                    throw new SQLException("No existe usuario");
           
            con.commit();
            conexion.cerrarConexion(con);
            return true;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false; 
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    }  
    
    public DefaultTableModel MovimientosAbono(String idCliente)
    {
        try
        {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            DefaultTableModel modelo;
            try
            {
                ResultSet rs = s.executeQuery("SELECT abono.Fecha, abono.Importe, "
                        + "abono.Punto, abono.idTicket "
                        + "FROM abono INNER JOIN cliente "
                        + "ON cliente.idCliente=abono.Cliente_idCliente "
                        + "WHERE abono.Cliente_idCliente='"+idCliente+"';");
                modelo = new DefaultTableModel();
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for(int i=1;i <=cantidadColumnas;i++)
                {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                while(rs.next()){
                Object[] fila = new Object[cantidadColumnas];
                for(int i = 0; i<cantidadColumnas; i++)
                {
                    fila[i]=rs.getObject(i+1);
                }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{
                conexion.cerrarConexion(con);
            }
        }
        catch(SQLException e){
                System.out.println(e.getMessage());
                return null;
        }
    }
}
