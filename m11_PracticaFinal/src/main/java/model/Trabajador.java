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
public class Trabajador {
    private int iden;
    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contraseña;
    private int telefono;
    private String id_proyecto;
    private int horas;
    private String tipo;

    public int getIden() {
        return iden;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getId_proyecto() {
        return id_proyecto;
    }

    public int getHoras() {
        return horas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    
}
