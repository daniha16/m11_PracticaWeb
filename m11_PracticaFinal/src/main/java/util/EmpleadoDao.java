/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Trabajador;

/**
 *
 * @author danih
 */
public class EmpleadoDao {
    private Connection connection;

    public EmpleadoDao() {
        connection = DbUtil.getConnection();
        System.out.println("Hello there empeladoDao");
    }

    public void addTrabajador(Trabajador trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into trabajador(iden,dni,nombre,apellidos,correo,contrasena,telefono,horas,tipo) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
// Parameters start with 1 
            preparedStatement.setInt(1, trabajador.getIden());
            preparedStatement.setString(2, trabajador.getDni()); 
            preparedStatement.setString(3, trabajador.getNombre());
            preparedStatement.setString(4, trabajador.getApellidos());
            preparedStatement.setString(5, trabajador.getCorreo());
            preparedStatement.setString(6, trabajador.getContraseña());
            preparedStatement.setInt(7, trabajador.getTelefono());
            preparedStatement.setDouble(8, trabajador.getHoras());
            preparedStatement.setString(9, trabajador.getTipo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteTrabajador(int trabajadorIden) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from trabajador where iden=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, trabajadorIden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateTrabajador(Trabajador trabajador) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update trabajador dni=?, nombre=?, apellidos=?, correo=?, contrasena=?, telefono=?, horas=?, tipo=?" + "where iden=?");
// Parameters start with 1 
            
            preparedStatement.setString(1, trabajador.getDni()); 
            preparedStatement.setString(2, trabajador.getNombre());
            preparedStatement.setString(3, trabajador.getApellidos());
            preparedStatement.setString(4, trabajador.getCorreo());
            preparedStatement.setString(5, trabajador.getContraseña());
            preparedStatement.setInt(6, trabajador.getTelefono());
            preparedStatement.setFloat(7, trabajador.getHoras());
            preparedStatement.setString(8, trabajador.getTipo());
            preparedStatement.setInt(9, trabajador.getIden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Trabajador> getAllEmpleados() {
        List<Trabajador> trabajadoresdb = new ArrayList<Trabajador>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from trabajador where tipo='Empleado';");
                while (rs.next()) {
                    Trabajador trabajador = new Trabajador();
                    trabajador.setIden(rs.getInt("iden"));
                    trabajador.setDni(rs.getString("dni"));
                    trabajador.setNombre(rs.getString("nombre"));
                    trabajador.setApellidos(rs.getString("apellidos"));
                    trabajador.setCorreo(rs.getString("correo"));
                    trabajador.setContraseña(rs.getString("contrasena"));
                    trabajador.setTelefono(rs.getInt("telefono"));
                    trabajador.setHoras(rs.getFloat("horas"));
                    trabajador.setTipo(rs.getString("tipo"));
                    trabajadoresdb.add(trabajador);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            System.out.println("SI QUE LOS HAY!");
            return trabajadoresdb;
        }
        else
        {
            System.out.println("TREMENDA F");
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Trabajador getTrabajadorByIden(int trabajadorIden) {
        Trabajador trabajador = new Trabajador();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from trabajador where iden=?");
            preparedStatement.setInt(1, trabajadorIden);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                trabajador.setIden(rs.getInt("iden"));
                trabajador.setDni(rs.getString("dni"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setApellidos(rs.getString("apellidos"));
                trabajador.setCorreo(rs.getString("correo"));
                trabajador.setContraseña(rs.getString("contrasena"));
                trabajador.setTelefono(rs.getInt("telefono"));
                trabajador.setHoras(rs.getFloat("horas"));
                trabajador.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return trabajador;
    }
}
