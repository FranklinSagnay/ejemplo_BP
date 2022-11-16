/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bit.spring.io;

/**
 *
 * @author james
 */
public class Input {
    String codigo;
    Object entidad;
    Integer tipoOperacion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object getEntidad() {
        return entidad;
    }

    public void setEntidad(Object entidad) {
        this.entidad = entidad;
    }

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Integer tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    
}
