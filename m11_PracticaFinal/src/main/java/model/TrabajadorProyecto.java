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
public class TrabajadorProyecto {
    private String id_proyecto;
    private String iden_trabajador;
    private int horas;

    public String getId_proyecto() {
        return id_proyecto;
    }

    public String getIden_trabajador() {
        return iden_trabajador;
    }

    public int getHoras() {
        return horas;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public void setIden_trabajador(String iden_trabajador) {
        this.iden_trabajador = iden_trabajador;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
}
