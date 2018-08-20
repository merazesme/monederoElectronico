/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fabiola Paez
 */
public class modeloCliente {
    private ConexionBD conexion= new ConexionBD();
    public boolean agregarCliente(String nombre, String apellidos, String correo, String telefono, String fecha, String direccion, String genero, int edad) 
    {  
        try
        {   Connection con= conexion.abrirConexion(); 
            Statement s= con.createStatement(); 
            int registro =s.executeUpdate("insert into cliente(Nombre, Apellidos, Puntos, Email, Direccion, Sexo, Telefono, FechaNac, Edad)"
                                         + "values('"+nombre+"','"+apellidos+"',0,'"+correo+"','"+direccion+"','"+genero+"','"+telefono+"','"+fecha+"',"+edad+");"
            ); 
            conexion.cerrarConexion(con); 
            return true; 
        }
        catch(SQLException e)
        {   return false;    
        }
    }
}
