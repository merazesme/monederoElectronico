/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fabiola Paez
 */
public class modeloCliente {
    private ConexionBD conexion= new ConexionBD();
    public int agregarCliente(String nombre, String apellidos, String correo, String telefono, String fecha, String direccion, int genero, int edad) 
    {  
        try
        {   int id=-2; 
            Connection con= conexion.abrirConexion(); 
            PreparedStatement s=con.prepareStatement("insert into cliente(Nombre, Apellidos, Puntos, Email, Direccion, Sexo, Telefono, FechaNac, Edad)"
                                         + "values('"+nombre+"','"+apellidos+"',0,'"+correo+"','"+direccion+"','"+genero+"','"+telefono+"','"+fecha+"',"+edad+");"
            ,PreparedStatement.RETURN_GENERATED_KEYS); 
            s.executeUpdate(); 
            ResultSet generatedKeys = s.getGeneratedKeys();
            if (generatedKeys.next())
                id = generatedKeys.getInt(1);
            conexion.cerrarConexion(con); 
            return id; 
        }
        catch(SQLException e)
        {   return -1;    
        }
    }
}
