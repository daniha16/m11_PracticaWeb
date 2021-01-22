/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danih
 */
public class Empresa {
    private String cif;
    private String nombre;
    private String direccion;
    private int codigo_postal;
    private String poblacion;
    private String provincia;
    private int telefono;
    
    public String getCif(){
        return cif;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }
    
    public String getPoblacion(){
        return poblacion;
    }
    
    public String getProvincia(){
        return provincia;
    }
    public int getTelefono(){
        return telefono;
    }
    
    public void setCif(String cif){
        this.cif=cif;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    
    
    public void setPoblacion(String poblacion){
        this.poblacion=poblacion;
    }
    
    public void setProvincia(String provincia){
        this.provincia=provincia;
    }
    
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
}
