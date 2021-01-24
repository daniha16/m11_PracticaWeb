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

/**
 *
 * @author danih
 */
public class ProyectoDao {
    private Connection connection;

    public ProyectoDao() {
        connection = DbUtil.getConnection();
    }

    public void addProyecto(Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into proyecto(id,tiempo,descripcion,cif_empresa) values (?, ?, ?, ? )");
// Parameters start with 1 
            
            preparedStatement.setFloat(1, proyecto.getTiempo());            
            preparedStatement.setString(2, proyecto.getDescripcion());
            preparedStatement.setString(3, proyecto.getCif_empresa());
            preparedStatement.setString(4, proyecto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteProyecto(String proyectoId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from proyecto_trabajadores where id_proyecto=?");
            System.out.println("ID: "+proyectoId);
            preparedStatement.setString(1, proyectoId);
            preparedStatement.executeUpdate();
            List<Proyecto> proyectos = getAllProyectos();
            for(Proyecto elem: proyectos){
                System.out.println(elem.getId());
            }
            preparedStatement = connection.prepareStatement("delete from proyecto where id=?");
            preparedStatement.setString(1, proyectoId);
            preparedStatement.executeUpdate();
            proyectos = getAllProyectos();
            System.out.println("NEW LISTA");
            for(Proyecto elem: proyectos){
                System.out.println(elem.getId());
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateProyecto(Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto set tiempo=?, descripcion=?, cif_empresa=?" + "where id=?");
// Parameters start with 1 
            System.out.println("INSIDE updateProyecto");
            preparedStatement.setFloat(1, proyecto.getTiempo());            
            preparedStatement.setString(2, proyecto.getDescripcion());
            preparedStatement.setString(3, proyecto.getCif_empresa());
            preparedStatement.setString(4, proyecto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Proyecto> getAllProyectos() {
        List<Proyecto> proyectodb = new ArrayList<Proyecto>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from proyecto;");
                while (rs.next()) {
                    Proyecto proyecto = new Proyecto();
                    proyecto.setId(rs.getString("id"));
                    proyecto.setTiempo(rs.getInt("tiempo"));
                    proyecto.setDescripcion(rs.getString("descripcion"));
                    proyecto.setCif_empresa(rs.getString("cif_empresa"));
                    proyectodb.add(proyecto);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return proyectodb;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Proyecto getProyectoById(String proyectoId) {
        Proyecto proyecto = new Proyecto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto where id=?");
            preparedStatement.setString(1, proyectoId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                proyecto.setId(rs.getString("id"));
                proyecto.setTiempo(rs.getInt("tiempo"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setCif_empresa(rs.getString("cif_empresa"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return proyecto;
    }
    
    public int getTimeProyecto(String proyectoId) {
        int tiempo = 0;
        try{
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("select tiempo from proyecto where id=?;");
            preparedStatement.setString(1, proyectoId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                tiempo = rs.getInt("tiempo");
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return tiempo;
    }
    public void addTimeProyecto(int tiempo, Proyecto proyecto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto tiempo=?, descripcion=?, cif_empresa=?" + "where id=?");
// Parameters start with 1 
            
            preparedStatement.setFloat(1, proyecto.getTiempo()+tiempo);            
            preparedStatement.setString(2, proyecto.getDescripcion());
            preparedStatement.setString(3, proyecto.getCif_empresa());
            preparedStatement.setString(4, proyecto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }
}
