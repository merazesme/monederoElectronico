/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class modeloAbonos {
    private ConexionBD conexion = new ConexionBD();
    
    public boolean insertarAbono(String fecha, int puntos, Double importe, int idTicket, int idCliente, int idEmpleado) 
    {  
        PreparedStatement sentencia1 = null;
        int idC=0;
        int idA=0;
        
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

            //Compara si ya existe abono
            rs = s.executeQuery("SELECT idTicket FROM abono WHERE idTicket="+idTicket+";"); 
            while (rs.next())
            {
                idA=rs.getInt (1);
            }
            if(idA==idTicket)
                    throw new SQLException("Ya existe ticket");      

            //Agrega abono
            sentencia1 = con.prepareStatement("INSERT INTO abono (idAbono, Fecha, Punto, "
                    + "Importe, idTicket, Cliente_idCliente, Empleado_idEmpleado) "
                    + "VALUES (NULL, '"+fecha+"', '"+puntos+"', '"+importe+"', '"+idTicket+"', "
                    + "'"+idCliente+"', '"+idEmpleado+"');");
            
            int s1=sentencia1.executeUpdate(); 
            if(s1==0)
                    throw new SQLException("Error al generar abono");
           
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
}