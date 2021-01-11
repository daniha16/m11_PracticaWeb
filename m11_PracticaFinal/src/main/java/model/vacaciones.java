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
public class Vacaciones {
    private Timestamp startdate;
    private Timestamp enddate;
    private int iden_trabajador;

    public Timestamp getStartdate() {
        return startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public int getIden_trabajador() {
        return iden_trabajador;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public void setIden_trabajador(int iden_trabajador) {
        this.iden_trabajador = iden_trabajador;
    }
    
    
}
