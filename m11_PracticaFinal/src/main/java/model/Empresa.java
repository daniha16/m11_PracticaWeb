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
    private int cif;
    private String nombre;
    private String direccion;
    private int codigo_postal;
    private String poblacion;
    private String provincia;
    private int telefono;
    
    public int getCif(){
        return cif;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public int getCodigoPostal(){
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
    
    public void setCif(int cif){
        this.cif=cif;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    
    public void setCodigoPostal(int cp){
        this.codigo_postal=cp;
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
