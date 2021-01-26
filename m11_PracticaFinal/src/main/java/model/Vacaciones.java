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
public class Vacaciones {
    private Timestamp inicio;
    private Timestamp fin;
    private int iden_trabajador;
    private String tipo;

    public Timestamp getInicio() {
        return inicio;
    }

    public Timestamp getFin() {
        return fin;
    }

    public int getIden_trabajador() {
        return iden_trabajador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public void setFin(Timestamp fion) {
        this.fin = fion;
    }

    public void setIden_trabajador(int iden_trabajador) {
        this.iden_trabajador = iden_trabajador;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    
}