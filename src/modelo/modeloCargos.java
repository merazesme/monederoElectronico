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
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ITZEL
 */
public class modeloCargos {
    ConexionBD conexion = new ConexionBD();
    
    public DefaultTableModel productosConsultar(String idS){
         try{
            //Abrir la conexión
            Connection con = conexion.abrirConexion();
            //Para generar la consulta
            Statement s = con.createStatement();
            //Para establecer el modelo al JTable
            DefaultTableModel modelo;
            
            try{
                //Ejecuta la consulta
                ResultSet rs = s.executeQuery("SELECT idPremios as ID, nombre as 'Nombre del Poroducto', Puntos, "
                        + "inventario.idInventario from premios "
                        + "INNER JOIN inventario ON inventario.Premios_idPremios = premios.idPremios "
                        + "WHERE inventario.Sucursal_idSucursal = " + idS);
                //Para establecer el modelo al JTable
                modelo = new DefaultTableModel();
                //Obtengo la información de las consultas que se están consultando
                ResultSetMetaData rsMd = rs.getMetaData();
                //La cantidad de columnas que tiene la consulta
                int cantidadColumnas = rsMd.getColumnCount();
                //Establecer como cabeceras el nombre de las columnas
                for(int i = 1; i <= cantidadColumnas; i++){
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
                //Creando las filas para el JTable
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for(int i = 0; i < cantidadColumnas; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
            }finally{//Cuando se usa excepciones; siempre se ejecuta no importa que haya error o no
                //Cerrar conexión (objeto de resultSet)
                conexion.cerrarConexion(con);
            }
        }catch(SQLException e){
             return null;
        }
    }
    
    public String[] puntosAcumulados(String id){   
       try
        {
            //abrir conexión
            Connection con= conexion.abrirConexion(); 
            //generar consultas
            Statement s = con.createStatement(); 
            //consulta
            ResultSet rs = s.executeQuery("SELECT `Nombre`, `Apellidos`, `Puntos` FROM `cliente` WHERE `idCliente` = " + id + ";");
        
            //declaración del array
            String [] a = new String [3];
            rs.next();
            //copiar del resultset al array
            a[0] = rs.getString(1);
            a[1] = rs.getString(2);
            a[2] = rs.getString(3);

            //cerrar conexión
            conexion.cerrarConexion(con); 
            return a; 
        }
        catch(SQLException e)
        {
          return null;    
        }
    }
    
    public boolean hacerCargo(String fecha, String idC, String idE, String idI, int puntos){
        PreparedStatement updateTransaccion1 = null;
        PreparedStatement updateTransaccion2 = null;
        
        System.out.println("fecha: "+fecha);
        System.out.println("INSERT INTO `cargo`(`Fecha`, `Cliente_idCliente`, `Empleado_idEmpleado`, "
                + "`Inventario_idInventario`) VALUES "
                + "("+fecha+","+idC+","+idE+","+idI+")");
        String consultaCargo="INSERT INTO `cargo`(`Fecha`, `Cliente_idCliente`, `Empleado_idEmpleado`, "
                + "`Inventario_idInventario`) VALUES "
                + "('"+fecha+"',"+idC+","+idE+","+idI+")";
        String consultaCliente="UPDATE `cliente` SET `Puntos`=`Puntos`-"+puntos+" WHERE `idCliente` = "+idC+";";
        
        Connection con = null;
        try
        {
            con= conexion.abrirConexion(); 
            con.setAutoCommit(false);
            updateTransaccion1 = con.prepareStatement(consultaCargo);
            updateTransaccion2 = con.prepareStatement(consultaCliente);
           
            int r1=updateTransaccion1.executeUpdate(); 
            int r2=updateTransaccion2.executeUpdate(); 
            if(r1 == 0 || r2 == 0)
                throw new SQLException("No se ha guardado el movimiento");
           
            con.commit();
            conexion.cerrarConexion(con);
            return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
}
