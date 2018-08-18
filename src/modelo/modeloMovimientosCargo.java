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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ITZEL
 */
public class modeloMovimientosCargo {
    ConexionBD conexion = new ConexionBD();
    public DefaultTableModel productosConsultar(String idC){
         try{
            //Abrir la conexión
            Connection con = conexion.abrirConexion();
            //Para generar la consulta
            Statement s = con.createStatement();
            //Para establecer el modelo al JTable
            DefaultTableModel modelo=null;
            
            try{
                //Ejecuta la consulta
                ResultSet rs = s.executeQuery("SELECT `Fecha`, cargo.Empleado_idEmpleado as 'ID Empleado', empleado.Nombre as 'Nombre Empleado', "
                        + "empleado.Apellidos as 'Apellido Empleado', premios.Nombre as 'Premio', premios.Puntos as 'Puntos', "
                        + "sucursal.Nombre as 'Sucursal' FROM cargo " +
                        "INNER JOIN empleado ON empleado.idEmpleado = cargo.Empleado_idEmpleado " +
                        "INNER JOIN inventario ON inventario.idInventario = cargo.Inventario_idInventario " +
                        "INNER JOIN premios ON premios.idPremios = inventario.Premios_idPremios " +
                        "INNER JOIN sucursal ON sucursal.idSucursal = inventario.Sucursal_idSucursal " +
                        "WHERE cargo.Cliente_idCliente = " + idC);
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
}
