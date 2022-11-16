/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bit.spring.controller;

import com.bit.spring.model.Entrada;
import com.bit.spring.model.Respuesta;
import com.bit.spring.modelo.Pelicula;
import com.bit.spring.service.PeliculaServicio;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author james
 */
@RestController
public class PeliculaController {

    @Autowired
    private PeliculaServicio servicio;

    @GetMapping("/lista")
    public List<Pelicula> lista() {
        List<Pelicula> peliculas = this.servicio.getPelicula();
        return peliculas;
    }

    @GetMapping("/pelicula/{id}")
    public @ResponseBody
    Pelicula consultaId(@PathVariable(name = "id") Integer id) {
        return this.servicio.getPelicula(id);
    }

    @GetMapping("/pelicula")
    public @ResponseBody
    Pelicula consultaIden(@RequestHeader(name = "country", defaultValue = "Mongolia") String pais, @RequestParam(name = "id") Integer id) {
        Pelicula result = null;
        if (pais.toLowerCase().contains("ecuador")) {
            result = this.servicio.getPelicula(id);
        } else {
            result = new Pelicula("Busqueda permitida solo para Ecuador");
        }
        return result;
    }

    @GetMapping("/genero")
    public @ResponseBody
    List<Pelicula> consultaGenObs(@RequestParam(name = "genero") String genero, @RequestParam(name = "observacion") String observacion) {
        return this.servicio.getPelicula(genero, observacion);
    }
    
    @PostMapping("/suscribir")
    public @ResponseBody Respuesta suscribir(@RequestBody Entrada suscribe) {
        Respuesta respuesta= new Respuesta();
        boolean estado = this.servicio.suscribir(suscribe.getCliente(), suscribe.getPelicula());
        respuesta.setRespuesta(estado);
        respuesta.setMensaje(estado? "OK": "Error en la suscripcion");
        return respuesta;
    }
    
    @GetMapping("/paginado")
    public @ResponseBody Respuesta consultaPaginada(@RequestParam(name = "cantidad") Integer cantidad, @RequestParam(name = "inicio") Integer inicio) {
        Respuesta respuesta= new Respuesta();
        try {
            List<Pelicula> data = this.servicio.getPelicula(inicio, cantidad);
            respuesta.setMensaje("OK");
            respuesta.setRespuesta(data);
        } catch (RuntimeException e) {
            respuesta.setMensaje("Error, " + e.toString());
        }
        
        return respuesta;
    }
    
    

}
