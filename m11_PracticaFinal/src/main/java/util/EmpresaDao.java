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
import model.Empresa;


/**
 *
 * @author danih
 */
public class EmpresaDao {
    private Connection connection;

    public EmpresaDao() {
        connection = DbUtil.getConnection();
    }

    public void addEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into empresa(cif,nombre,direccion,codigo_postal,poblacion,provincia,telefono) values (?, ?, ?, ?, ?, ?, ? )");
// Parameters start with 1 
            preparedStatement.setInt(1, empresa.getCif());
            preparedStatement.setString(2, empresa.getNombre()); 
            preparedStatement.setString(3, empresa.getDireccion());
            preparedStatement.setInt(4, empresa.getCodigoPostal());
            preparedStatement.setString(5, empresa.getPoblacion());
            preparedStatement.setString(6, empresa.getProvincia());
            preparedStatement.setInt(7, empresa.getTelefono());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void deleteEmpresa(int empresaCif) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from empresa where cif=?");
            // Parameters start with 1 
            preparedStatement.setInt(1, empresaCif);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
    }

    public void updateEmpresa(Empresa empresa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update empresa nombre=?, direccion=?, codigo_postal=?, poblacion=?, provincia=?, telefono=?" + "where cif=?");
// Parameters start with 1 
            
            preparedStatement.setString(1, empresa.getNombre()); 
            preparedStatement.setString(2, empresa.getDireccion());
            preparedStatement.setInt(3, empresa.getCodigoPostal());
            preparedStatement.setString(4, empresa.getPoblacion());
            preparedStatement.setString(5, empresa.getProvincia());
            preparedStatement.setInt(6, empresa.getTelefono());
            preparedStatement.setInt(7, empresa.getCif());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);            
        }
    }

    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresasdb = new ArrayList<Empresa>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from empresa;");
                while (rs.next()) {
                    Empresa empresa = new Empresa();
                    empresa.setCif(rs.getInt("cif"));
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setDireccion(rs.getString("direccion"));
                    empresa.setCodigoPostal(rs.getInt("codigo_postal"));
                    empresa.setPoblacion(rs.getString("poblacion"));
                    empresa.setProvincia(rs.getString("provincia"));
                    empresa.setTelefono(rs.getInt("telefono"));
                    empresasdb.add(empresa);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e);            
            }
            return empresasdb;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd");
            return null;
        }
       
    }

    public Empresa getEmpresaByCif(int empresaCif) {
        Empresa empresa = new Empresa();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where cif=?");
            preparedStatement.setInt(1, empresaCif);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                empresa.setCif(rs.getInt("cif"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setCodigoPostal(rs.getInt("codigo_postal"));
                empresa.setPoblacion(rs.getString("poblacion"));
                empresa.setProvincia(rs.getString("provincia"));
                empresa.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
            Log.logdb.error("SQL Exception: " + e);
        }
        return empresa;
    }
}
