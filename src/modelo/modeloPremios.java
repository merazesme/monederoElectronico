/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
 * @author Holi
 */
public class modeloPremios {
    private ConexionBD conexion= new ConexionBD();
    
    
    public boolean transaccionAgregar(String nombre, int puntos, int cantidad, int sucursal) 
    {   
        PreparedStatement transaccionPremios = null;
        PreparedStatement transaccionInventario = null;
        
        Connection con = null;
        try
        {
            con= conexion.abrirConexion(); 
            con.setAutoCommit(false);
            
            //hago el primer insert en la tabla de premios
            String insertarPremios="insert into premios (nombre, puntos) values('"+nombre+"', "+puntos+");";
            transaccionPremios = con.prepareStatement(insertarPremios);
            int r1=transaccionPremios.executeUpdate(); 
            
            //luego genero la consulta para traer el id del premio para guardar datos en la tabla de inventario
            Statement s = con.createStatement();
            //En este variable se guarda la consulta y que es de tipo result set
            ResultSet sql = s.executeQuery("select idPremios from premios where Nombre = '"+nombre+"'");
            //este se usa para recorrer toda la consulta
            int idPremio = 0;
            while(sql.next())
            {
                //Lo adquirido de la consukta se pasa a una variable de tipo string llamada captura
                idPremio = sql.getInt(1);
            }
            
            //genero el insert en la tabla inventario
            String insertarInventario="insert into inventario (Premios_idPremios, Sucursal_idSucursal, cantidad) values("+idPremio+", "+sucursal+", "+cantidad+");";
            transaccionInventario = con.prepareStatement(insertarInventario);
            int r2=transaccionInventario.executeUpdate(); 
            
            if(r1 == 0 || r2 ==0)
                    throw new SQLException("Error al insertar el producto");
           
            con.commit();
            conexion.cerrarConexion(con);
            return true;
        }
        catch(SQLException e)
        {   //cualquier error que traiga la bd al querer insertar datos incorrectos
            JOptionPane.showMessageDialog(null, "No se guardó el registro.\nVerifique los campos.");
//            try 
//            {
//                con.rollback();
//            } catch (SQLException ex) {
//                
//            }
            return false; 
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    }
    public boolean transaccionModificar(String nombre, int puntos, int cantidad, int sucursal, int idPremio) 
    {   
        PreparedStatement transaccionPremios = null;
        PreparedStatement transaccionInventario = null;
        
        Connection con = null;
        try
        {
            con= conexion.abrirConexion(); 
            con.setAutoCommit(false);
            
            //se modifica los datos generales del producto en todas la sucursales
            String modificarPremios="update premios set Nombre = '"+nombre+"', Puntos = "+puntos+" where idPremios = "+idPremio+";";
            transaccionPremios = con.prepareStatement(modificarPremios);
            int r1=transaccionPremios.executeUpdate(); 
            
            //se modifica la cantidad del producto en la sucursal desde la que se ingreso al sistema
            String modificarInventario="update inventario set cantidad = "+cantidad+" where Premios_idPremios = "+idPremio+" && Sucursal_idSucursal = "+sucursal+";";
            transaccionInventario = con.prepareStatement(modificarInventario);
            int r2=transaccionInventario.executeUpdate(); 
            
            if(r1 == 0 || r2 ==0)
                    throw new SQLException("Error al modificar el producto");
           
            con.commit();
            conexion.cerrarConexion(con);
            return true;
        }
        catch(SQLException e)
        {   //cualquier error que traiga la bd al querer insertar datos incorrectos
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos");
//            try 
//            {
//                con.rollback();
//            } catch (SQLException ex) {
//                
//            }
            return false; 
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    }
    public boolean transaccionEliminar(int idPremio) 
    {   
        PreparedStatement transaccionPremios = null;
        PreparedStatement transaccionInventario = null;
        
        Connection con = null;
        try
        {
            con= conexion.abrirConexion(); 
            con.setAutoCommit(false);
            
            //se elimina primero el registro en la tabla de inventario por las claves foraneas, se borra de todas las sucursales
            String eliminarInventario="delete from inventario where Premios_idPremios="+idPremio+";";
            transaccionInventario = con.prepareStatement(eliminarInventario);
            int r2=transaccionInventario.executeUpdate(); 
            
            //despues se elimana el producto en general
            String eliminarPremios="delete from premios where idPremios = "+idPremio+";";
            transaccionPremios = con.prepareStatement(eliminarPremios);
            int r1=transaccionPremios.executeUpdate(); 
            
            if(r1 == 0 || r2 ==0)
                    throw new SQLException("Error al eliminar el producto");
           
            con.commit();
            conexion.cerrarConexion(con);
            return true;
        }
        catch(SQLException e)
        {   //cualquier error que traiga la bd al querer insertar datos incorrectos
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos");
//            try 
//            {
//                con.rollback();
//            } catch (SQLException ex) {
//                
//            }
            return false; 
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al intentar conectar con el servidor.");
            return false;
        }
    }
    // Carga las actividades guardadas en la BD a la tabla 
    public DefaultTableModel mostrarRegistrosTabla(int sucursal)
    {   try
        {   // para abrir conexion a la BD 
            Connection con = conexion.abrirConexion(); 
            // para generar consultas 
            Statement s= con.createStatement(); 
            // para establecer el modelo al jtable 
            DefaultTableModel modelo; 
            try
            {   ResultSet rs = s.executeQuery("select idPremios, Nombre, Puntos, Sucursal_idSucursal, cantidad from premios " +
                "INNER JOIN inventario on premios.idPremios = inventario.Premios_idPremios and Sucursal_idSucursal = "+sucursal+";"); 
                // para establecer el modelo al jtable 
                modelo= new DefaultTableModel(); 
                // obteniendo la informacion de las columnas que esta siendo consultadas 
                ResultSetMetaData rsMD = rs.getMetaData(); 
                // la cantidad de conlumnas que tien la consulta
                int cantidadColumnas = rsMD.getColumnCount(); 
                // establecer como cabecera el nombre de las columnas 
                for( int i= 1; i<= cantidadColumnas; i++)
                    modelo.addColumn(rsMD.getColumnLabel(i)); 
                // creando las filas para el jtable 
                while (rs.next())
                {   Object[] fila = new Object[cantidadColumnas]; 
                    for ( int i=0; i< cantidadColumnas; i++)
                        fila[i]= rs.getObject(i+1); 
                    modelo.addRow(fila); 
                }
                return modelo; 
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return null;
            }
            finally
            {   //cerrar objeto de result 
                conexion.cerrarConexion(con); 
            }
        }
        catch(SQLException e)
        {   return null; 
        }
    }
}
