/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bit.spring.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author james
 */
@Entity
@Table(name = "PELICULA")
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEL_PK")
    private Integer pelPk;
    @Basic(optional = false)
    @Column(name = "PEL_CODIGO")
    private String pelCodigo;
    @Basic(optional = false)
    @Column(name = "PEL_NOMBRE")
    private String pelNombre;
    @Basic(optional = false)
    @Column(name = "PEL_GENERO")
    private String pelGenero;
    @Column(name = "PEL_OBSERVACION")
    private String pelObservacion;
    @Basic(optional = false)
    @Column(name = "PEL_ESTADO")
    private Boolean pelEstado;

    public Pelicula() {
    }

    public Pelicula(Integer pelPk) {
        this.pelPk = pelPk;
    }
    
    public Pelicula(String pelObservacion) {
        this.pelObservacion = pelObservacion;
    }

    public Pelicula(Integer pelPk, String pelCodigo, String pelNombre, String pelGenero, boolean pelEstado) {
        this.pelPk = pelPk;
        this.pelCodigo = pelCodigo;
        this.pelNombre = pelNombre;
        this.pelGenero = pelGenero;
        this.pelEstado = pelEstado;
    }

    public Integer getPelPk() {
        return pelPk;
    }

    public void setPelPk(Integer pelPk) {
        this.pelPk = pelPk;
    }

    public String getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(String pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public String getPelNombre() {
        return pelNombre;
    }

    public void setPelNombre(String pelNombre) {
        this.pelNombre = pelNombre;
    }

    public String getPelGenero() {
        return pelGenero;
    }

    public void setPelGenero(String pelGenero) {
        this.pelGenero = pelGenero;
    }

    public String getPelObservacion() {
        return pelObservacion;
    }

    public void setPelObservacion(String pelObservacion) {
        this.pelObservacion = pelObservacion;
    }

    public Boolean getPelEstado() {
        return pelEstado;
    }

    public void setPelEstado(Boolean pelEstado) {
        this.pelEstado = pelEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pelPk != null ? pelPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.pelPk == null && other.pelPk != null) || (this.pelPk != null && !this.pelPk.equals(other.pelPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pelicula[ " + pelCodigo + ": " + pelNombre + " ]";
    }
    
}
