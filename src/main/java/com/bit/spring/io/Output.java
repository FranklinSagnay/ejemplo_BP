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
public class Output {
    
    String mensaje;
    String codigo;
    Object entidad;

    public Output() {
    }

    public Output(String mensaje, String codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;    
    }

    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

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
    
}
