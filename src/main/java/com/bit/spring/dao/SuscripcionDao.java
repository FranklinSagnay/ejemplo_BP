package com.bit.spring.dao;

import com.bit.spring.modelo.Pelicula;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

/**
 *
 * @author james
 */
@Repository
public class SuscripcionDao {

    @Autowired
    private PeliculaJPARepository peliculaJPARepository;

    private Map<String, List<Pelicula>> suscripciones;

    public SuscripcionDao() {
        this.suscripciones = new HashMap<>();
    }

    public boolean suscribir(String cliente, Pelicula suscripcion) {
        boolean resultado = false;
        if (suscripciones.containsKey(cliente)) {
            resultado = suscripciones.get(cliente).add(suscripcion);
        } else {
            suscripciones.put(cliente, List.of(suscripcion));
            resultado = true;
        }
        return resultado;
    }

    public Map<String, List<Pelicula>> getSuscripciones() {
        return suscripciones;
    }

    public List<Pelicula> getSuscripcion(String cliente) {
        return suscripciones.containsKey(cliente) ? suscripciones.get(cliente) : null;
    }
    
    public Pelicula getPelicula(String codigo){
        Pelicula plantilla = new Pelicula();
        plantilla.setPelCodigo(codigo);
        return peliculaJPARepository.findOne(Example.of(plantilla)).get();
    }       
    
    public List<Pelicula> getPelicula(String genero, String observacion){
        Pelicula plantilla = new Pelicula();
        plantilla.setPelGenero(genero);
        plantilla.setPelObservacion(observacion);
        return peliculaJPARepository.findAll(Example.of(plantilla));
    }
    
    public List<Pelicula> getPelicula(Integer inicio, Integer cantidad){        
        return peliculaJPARepository.findAll(PageRequest.of(inicio, cantidad)).toList();
    }
    
    public List<Pelicula> getPelicula(){
        return peliculaJPARepository.findAll();
    }
    
    public Pelicula getPelicula(Integer id){
        return peliculaJPARepository.findById(id).get();
    }
        

}
