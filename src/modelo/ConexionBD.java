/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.controlElegirSucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.elegirsucursal;

/**
 *
 * @author ITZEL
 */
public class ConexionBD {
    public JFrame vista;
    public Connection abrirConexion() throws SQLException{
        Connection con;
        //Para conectarnos a nuestrza base de datos
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            controlElegirSucursal.setIp("localhost");
            if (controlElegirSucursal.ip != "localhost")
            con = DriverManager.getConnection("jdbc:mysql://"+controlElegirSucursal.ip+":3306/monedero", "root", "123456");
            else 
            con = DriverManager.getConnection("jdbc:mysql://"+controlElegirSucursal.ip+":3306/monedero", "root", "");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo abrir la conexión con la BD.");
            if (JOptionPane.showConfirmDialog(vista,"¿Desea cambiar de servidor?", "Libreria",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
            {
               elegirsucursal vistasu = new elegirsucursal();
               controlElegirSucursal cs = new controlElegirSucursal(vistasu,1);
               cs.iniciarVista();
            }
            con=null;
        }
        return con;
    }
            
    public void cerrarConexion(Connection c)
            throws SQLException{
        try{
            if(!c.isClosed()){
                c.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión de la BD.");
        }
    }
}
