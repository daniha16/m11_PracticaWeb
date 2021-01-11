/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author danih
 */
public class RegistroEmpleado {
    private Timestamp entrada;
    private Timestamp salida;
    private int iden_trabajador;

    public Timestamp getEntrada() {
        return entrada;
    }

    public Timestamp getSalida() {
        return salida;
    }

    public int getIden_trabajador() {
        return iden_trabajador;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public void setSalida(Timestamp salida) {
        this.salida = salida;
    }

    public void setIden_trabajador(int iden_trabajador) {
        this.iden_trabajador = iden_trabajador;
    }
    
    
}
