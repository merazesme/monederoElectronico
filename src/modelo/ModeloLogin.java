/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alfredo
 */
public class ModeloLogin {
    private ConexionBD conexion = new ConexionBD();
      
    public String[] ingresar(String usu, String contra)
    {
        String[] capturar= new String [3];
        capturar[0]="0";
        capturar[1]="";
        
        int control=0;
        ResultSet sql;       
         try {
            Connection con = conexion.abrirConexion();
            Statement s = con.createStatement();
            //En este variable se guarda la consulta y que es de tipo result set
            sql = s.executeQuery("SELECT * FROM empleado WHERE Usuario='" + usu + "' && Contraseña='" + contra + "' ");
            //este se usa para recorrer toda la consulta
            while(sql.next())
            {
                //Lo adquirido de la consukta se pasa a una variable de tipo string llamada captura
                capturar[0] = sql.getString("Tipo");
                capturar[1] = sql.getString("Sucursal_idSucursal");
                capturar[2] = sql.getString("idEmpleado");
            }
            //Se compara el tipo de usuario
            if(capturar[0].equals("Empleado"))
            {
                //Se retorna un 1 si captura es Administrador
                capturar[0] = "1";
            }
            else if(capturar[0].equals("Administrador"))
            {
                //Se retorna un 2 si captura es Usuario
                capturar[0] = "2";
            }
            else if((!capturar[0].equals("Administrador")) && (!capturar[0].equals("Empleado")))
            {
                //Se retorna un 3 si no es nignuno de los dos
                capturar[0] = "3";
            }
           conexion.cerrarConexion(con);
        }
        catch (SQLException ex)
        {
//           JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos.");
        }
         catch(NullPointerException e){
             //Arroja un mensaje 
//            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
        }
        return capturar;
    }
}
