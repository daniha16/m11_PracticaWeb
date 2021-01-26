/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author danih
 */
public class DatosInforme {
    private int iden;
    private String nombre;
    private String dni;
    private String apellidos;
    private Timestamp entrada;
    private Timestamp salida;
    private Date fecha;

    public int getIden() {
        return iden;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public Timestamp getSalida() {
        return salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public void setSalida(Timestamp salida) {
        this.salida = salida;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
