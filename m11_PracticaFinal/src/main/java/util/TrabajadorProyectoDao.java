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
    
    public List<TrabajadorProyecto> getTPByIdProyecto(String id){
        System.out.println("IN HERE");
        List<TrabajadorProyecto> tpdb = new ArrayList<TrabajadorProyecto>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto_trabajadores where id_proyecto=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("IN HERE");
                TrabajadorProyecto trabajadorProyecto = new TrabajadorProyecto();
                trabajadorProyecto.setId_proyecto(rs.getString("id_proyecto"));
                System.out.println(trabajadorProyecto.getId_proyecto());
                trabajadorProyecto.setIden_trabajador(rs.getInt("iden_trabajador"));
                System.out.println(trabajadorProyecto.getIden_trabajador());
                trabajadorProyecto.setHoras(rs.getInt("horas"));
                System.out.println(trabajadorProyecto.getHoras());
                tpdb.add(trabajadorProyecto);
            }
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        
        return tpdb;
    }
    
    public List<TrabajadorProyecto> getProyectoByIden(int iden){
         List<TrabajadorProyecto> tpdb = new ArrayList<TrabajadorProyecto>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto_trabajadores where iden_trabajador=?");
            preparedStatement.setInt(1, iden);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TrabajadorProyecto trabajadorProyecto = new TrabajadorProyecto();
                trabajadorProyecto.setId_proyecto(rs.getString("id_proyecto"));
                trabajadorProyecto.setIden_trabajador(rs.getInt("iden_trabajador"));
                trabajadorProyecto.setHoras(rs.getInt("horas"));
                tpdb.add(trabajadorProyecto);
            }
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        
        return tpdb;
    }
    
    public TrabajadorProyecto getTrabajadorProyecto(int iden, String id){
        TrabajadorProyecto tp = new TrabajadorProyecto();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto_trabajadores where iden_trabajador=? and id_proyecto=?");
            preparedStatement.setInt(1, iden);
            preparedStatement.setString(2, id);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("...............getTrabajadorProyecto............");
            while(rs.next()){
                tp.setIden_trabajador(rs.getInt("iden_trabajador"));
                System.out.println(rs.getInt("iden_trabajador"));
                tp.setId_proyecto(rs.getString("id_proyecto"));
                System.out.println(rs.getString("id_proyecto"));
                tp.setHoras(rs.getFloat("horas"));
                System.out.println(rs.getFloat("horas"));
            }
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return tp;
    }
    
    public float getTimeProyectoIden(int iden, String id) {
        float horas = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select horas from proyecto_trabajadores where iden_trabajador=? and id_proyecto=?");
            preparedStatement.setInt(1, iden);
            preparedStatement.setString(2, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                horas = rs.getFloat("horas");
            }
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return horas;
    }

    public void updateTimeTrabajadorProyecto(TrabajadorProyecto tp) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto_trabajadores set horas=? where iden_trabajador=? and id_proyecto=?");
            preparedStatement.setFloat(1, tp.getHoras());
            System.out.println("Horas2: "+tp.getHoras());
            preparedStatement.setInt(2, tp.getIden_trabajador());
            System.out.println("Iden2: "+tp.getIden_trabajador());
            preparedStatement.setString(3, tp.getId_proyecto());
            System.out.println("Id2: "+tp.getId_proyecto());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }
    
    
}
