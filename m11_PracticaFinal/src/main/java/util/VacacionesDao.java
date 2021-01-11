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
import model.Vacaciones;

/**
 *
 * @author danih
 */
public class VacacionesDao {
    private Connection connection;

    public VacacionesDao() {
        connection = DbUtil.getConnection();
    }

    public void addVacaciones(Vacaciones vacaciones) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vacaciones(iden,dni,nombre,apellidos,correo,contraseña,telefono,id_proyecto,horas,tipo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
// Parameters start with 1 
            preparedStatement.setTimestamp(1, vacaciones.getStartdate());
            preparedStatement.setTimestamp(2, vacaciones.getEnddate()); 
            preparedStatement.setInt(3, vacaciones.getIden_trabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteVacaciones(int trabajadorIden) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from vacaciones where iden_trabjador=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, trabajadorIden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateVacaciones(Vacaciones vacaciones) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update vacaciones startdate=?, enddate=?" + "where iden_tabajador=?");
// Parameters start with 1 
            preparedStatement.setTimestamp(1, vacaciones.getStartdate());
            preparedStatement.setTimestamp(2, vacaciones.getEnddate()); 
            preparedStatement.setInt(3, vacaciones.getIden_trabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Vacaciones> getAllVacaciones() {
        List<Vacaciones> vacacionesdb = new ArrayList<Vacaciones>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from vacaciones;");
                while (rs.next()) {
                    Vacaciones vacaciones = new Vacaciones();
                    vacaciones.setStartdate(rs.getTimestamp("startdate"));
                    vacaciones.setEnddate(rs.getTimestamp("enddate"));
                    vacaciones.setIden_trabajador(rs.getInt("iden_trabajador"));
                    vacacionesdb.add(vacaciones);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return vacacionesdb;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Vacaciones getVacacionesByIden(int trabajadorIden) {
        Vacaciones vacaciones = new Vacaciones();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vacaciones where iden_trabajador=?");
            preparedStatement.setInt(1, trabajadorIden);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                vacaciones.setStartdate(rs.getTimestamp("startdate"));
                vacaciones.setEnddate(rs.getTimestamp("enddate"));
                vacaciones.setIden_trabajador(rs.getInt("iden_trabajador"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return vacaciones;
    }
}
