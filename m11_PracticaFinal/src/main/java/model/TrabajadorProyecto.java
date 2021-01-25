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
    private int iden_trabajador;
    private float horas;

    public String getId_proyecto() {
        return id_proyecto;
    }

    public int getIden_trabajador() {
        return iden_trabajador;
    }

    public float getHoras() {
        return horas;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public void setIden_trabajador(int iden_trabajador) {
        this.iden_trabajador = iden_trabajador;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }
    
}
