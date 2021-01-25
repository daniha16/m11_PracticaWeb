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
import model.Peticion;
import model.Proyecto;

/**
 *
 * @author danih
 */
public class PeticionesDao {
    
    private Connection connection;
    
    public PeticionesDao() {
        connection = DbUtil.getConnection();
    }

    public void addPeticion(Peticion peticion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into peticiones(reqid,iden,concepto,resolucion,tipo,fecha) values (?, ?, ?, ? )");
// Parameters start with 1 
            
            preparedStatement.setInt(1, peticion.getReqid());            
            preparedStatement.setInt(2, peticion.getIden());
            preparedStatement.setString(3, peticion.getConcepto());
            preparedStatement.setString(4, peticion.getResolucion());
            preparedStatement.setString(5, peticion.getTipo());
            preparedStatement.setDate(6, peticion.getFecha());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deletePeticion(int peticionId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from proyecto where id=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, peticionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }
    
    public void denegarPeticion(int reqId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update peticiones set resolucion=?" + "where reqid=?");
// Parameters start with 1 
            preparedStatement.setString(1, "Denegada");
            preparedStatement.setInt(2, reqId);
            preparedStatement.executeUpdate();
            System.out.println("Base de datos supuestamente actualizada");
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }
    
    public void aceptarPeticion(int reqId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update peticiones set resolucion=?" + "where reqid=?");
// Parameters start with 1 
            preparedStatement.setString(1, "Aceptada");
            preparedStatement.setInt(2, reqId);
            preparedStatement.executeUpdate();
            System.out.println("Base de datos supuestamente actualizada");
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }
    
    public void updatePeticion(Peticion peticion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update peticiones set iden=?, concepto=?, resolucion=?" + "where reqid=?");
// Parameters start with 1 

            preparedStatement.setInt(1, peticion.getIden());
            preparedStatement.setString(2, peticion.getConcepto());
            preparedStatement.setString(3, peticion.getResolucion());
            preparedStatement.setInt(4, peticion.getReqid());
            preparedStatement.setString(5, peticion.getTipo());
            preparedStatement.setDate(6, peticion.getFecha());
            preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Peticion> getAllPeticiones() {
        List<Peticion> peticiondb = new ArrayList<Peticion>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from peticiones;");
                while (rs.next()) {
                    Peticion peticion = new Peticion();
                    peticion.setReqid(rs.getInt("reqid"));
                    peticion.setIden(rs.getInt("iden"));
                    peticion.setConcepto(rs.getString("concepto"));
                    peticion.setResolucion(rs.getString("resolucion"));
                    peticon.setTipo(rs.getString("tipo"));
                    peticion.setFecha(rs.getDate("fecha"));
            preparedStatement.executeUpdate();
                    peticiondb.add(peticion);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return peticiondb;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Peticion getPeticionById(int peticionId) {
        Peticion peticion = new Peticion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from peticiones where id=?");
            preparedStatement.setInt(1, peticionId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                peticion.setReqid(rs.getInt("reqid"));
                peticion.setIden(rs.getInt("iden"));
                peticion.setConcepto(rs.getString("concepto"));
                peticion.setResolucion(rs.getString("resolucion"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return peticion;
    }
}
