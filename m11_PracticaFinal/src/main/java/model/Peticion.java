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
public class Peticion {
    private int reqid;
    private int iden;   
    private String concepto;
    private String resolucion;

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
    
    
}
