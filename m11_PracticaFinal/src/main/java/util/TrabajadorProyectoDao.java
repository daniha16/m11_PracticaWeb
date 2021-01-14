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
import model.Proyecto;
import model.Trabajador;
import model.TrabajadorProyecto;

/**
 *
 * @author danih
 */
public class TrabajadorProyectoDao {
    private Connection connection;
    public TrabajadorProyectoDao() {
        connection = DbUtil.getConnection();
        System.out.println("Hello there");
    }

    public List<TrabajadorProyecto> getProyectoByIden(int iden){
         List<TrabajadorProyecto> tpdb = new ArrayList<TrabajadorProyecto>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from many_proyecto_has_many_trabajador where iden_trabajador=?");
            preparedStatement.setInt(1, iden);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TrabajadorProyecto trabajadorProyecto = new TrabajadorProyecto();
                trabajadorProyecto.setId_proyecto(rs.getString("id_proyecto"));
                trabajadorProyecto.setIden_trabajador(rs.getString("iden_trabajador"));
                trabajadorProyecto.setHoras(rs.getInt("horas"));
                tpdb.add(trabajadorProyecto);
            }
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        
        return tpdb;
    }
}
