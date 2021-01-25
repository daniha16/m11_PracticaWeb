/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.RegistroEmpleado;

/**
 *
 * @author danih
 */
public class RegistroEmpleadoDao {

    private Connection connection;

    public RegistroEmpleadoDao() {
        connection = DbUtil.getConnection();
    }

    public void addRegistroEmpleado(RegistroEmpleado registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into registroEmpleado(entrada, salida, iden_trabajador,fecha) values (?, ?, ?, ?)");
// Parameters start with 1 
            preparedStatement.setTimestamp(1, registro.getEntrada());
            preparedStatement.setTimestamp(2, registro.getSalida());
            preparedStatement.setInt(3, registro.getIden_trabajador());
            preparedStatement.setDate(4, registro.getFecha());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteRegistroEmpleado(int trabajadorIden) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from registroEmpleado where iden_trabajador=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, trabajadorIden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateRegistroEmpleados(RegistroEmpleado registro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update registroEmpleado entrada=?, salida=?, fecha=?" + "where iden_trabajador=?");
// Parameters start with 1 
            preparedStatement.setTimestamp(1, registro.getEntrada());
            preparedStatement.setTimestamp(2, registro.getSalida());
            preparedStatement.setDate(3, registro.getFecha());
            preparedStatement.setInt(4, registro.getIden_trabajador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public List<RegistroEmpleado> getAllRegistros() {
        List<RegistroEmpleado> registrosdb = new ArrayList<RegistroEmpleado>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from registroEmpleado;");
                while (rs.next()) {
                    RegistroEmpleado registro = new RegistroEmpleado();
                    registro.setEntrada(rs.getTimestamp("entrada"));
                    registro.setSalida(rs.getTimestamp("salida"));
                    registro.setIden_trabajador(rs.getInt("iden_trabajador"));
                    registrosdb.add(registro);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);
            }
            return registrosdb;
        } else {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }

    }

    public RegistroEmpleado getRegistroByIden(int trabajadorIden) {
        RegistroEmpleado registro = new RegistroEmpleado();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from registroEmpleado where iden_trabajador=?");
            preparedStatement.setInt(1, trabajadorIden);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                registro.setEntrada(rs.getTimestamp("entrada"));
                registro.setSalida(rs.getTimestamp("salida"));
                registro.setIden_trabajador(rs.getInt("iden_trabajador"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return registro;
    }
      public RegistroEmpleado getRegistroByDate(Date fecha) {
        RegistroEmpleado registro = new RegistroEmpleado();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from registroEmpleado where fecha=?");
            preparedStatement.setDate(1,fecha);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                registro.setEntrada(rs.getTimestamp("entrada"));
                registro.setSalida(rs.getTimestamp("salida"));
                registro.setIden_trabajador(rs.getInt("iden_trabajador"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return registro;
    }
}

