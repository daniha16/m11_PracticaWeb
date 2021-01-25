/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Date;
import java.sql.Time;

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
    private Time inicio;
    private Time fin;
    private Date fecha;

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
    public Date getFecha() {
        return fecha;
    }

    public Time getInicio() {
        return inicio;
    }

    public Time getFin() {
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
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }
    
    
}
