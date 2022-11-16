/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bit.spring.service;

import com.bit.spring.dao.SuscripcionDao;
import com.bit.spring.modelo.Pelicula;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author james
 */
@Service
public class PeliculaServicio {
    
    @Autowired
    private SuscripcionDao suscripcionDao;
    
    /**
     * Validar si el cliente existe, tiene registrado metodode pago, cumple resticciones de edad, localidad etc, etc.
     * @param cliente
     * @param suscripcion 
     */
    public boolean suscribir(String cliente, Pelicula suscripcion){
        boolean resultado = false;
        if (cliente != null && !cliente.isBlank() && suscripcion != null) {
            resultado = suscripcionDao.suscribir(cliente, suscripcion);
        }
        return resultado;
    }
    
    public List<Pelicula> getSuscripciones(String cliente){
        List<Pelicula> resultado = null;
        if (cliente != null && !cliente.isBlank()){
            resultado = suscripcionDao.getSuscripcion(cliente);
        }else{
            throw new RuntimeException("Cliente no existe en el sistema, por favor registrese");
        }
        return resultado;
    }
    
    public Pelicula getPelicula(String codigo){
        if(codigo == null || codigo.isBlank()){
            throw new RuntimeException("El codigo es obligatorio");
        }
        return suscripcionDao.getPelicula(codigo);
    }
    
    public Pelicula getPelicula(Integer id){
        if(id == null ){
            throw new RuntimeException("El ID es obligatorio");
        }
        return suscripcionDao.getPelicula(id);
    }
    
    public List<Pelicula> getPelicula(String genero, String observacion){
        if(genero == null || observacion == null || genero.isBlank() || observacion.isBlank()){
            throw new RuntimeException("El genero y la observacion son campos obligatorios");
        }
        return suscripcionDao.getPelicula(genero, observacion);
    }
    
    public List<Pelicula> getPelicula(Integer inicio, Integer cantidad){
        if(inicio == null || cantidad == null || inicio < 0|| cantidad < 0){
            throw new RuntimeException("El tamaño de pagina, o la cantidad de registros no puede ser nula ni menor a cero");
        }
        return suscripcionDao.getPelicula(inicio, cantidad);
    }
    
    public List<Pelicula> getPelicula(){
        return suscripcionDao.getPelicula();
    }
    
    
}
