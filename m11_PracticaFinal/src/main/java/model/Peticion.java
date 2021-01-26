/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author danih
 */
public class Peticion {
    private int reqid;
    private int iden;   
    private String concepto;
    private String resolucion;
    private String tipo;
    private Timestamp inicio;
    private Timestamp fin;

    public int getReqid() {
        return reqid;
    }
    
    public int getIden() {
        return iden;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getResolucion() {
        return resolucion;
    }
    public String getTipo() {
        return tipo;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }
    
    
}
