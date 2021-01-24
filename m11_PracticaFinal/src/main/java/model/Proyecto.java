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
public class Proyecto {
    private String id;
    private float tiempo;
    private String descripcion;
    private String cif_empresa;

    public String getId() {
        return id;
    }

    public float getTiempo() {
        return tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCif_empresa() {
        return cif_empresa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCif_empresa(String cif_empresa) {
        this.cif_empresa = cif_empresa;
    }
    
    
}
