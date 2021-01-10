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
    private int tiempo;
    private String text;
    private String cif_empresa;

    public String getId() {
        return id;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getText() {
        return text;
    }

    public String getCif_empresa() {
        return cif_empresa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCif_empresa(String cif_empresa) {
        this.cif_empresa = cif_empresa;
    }
    
    
}
