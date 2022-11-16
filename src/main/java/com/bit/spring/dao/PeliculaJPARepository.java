
package com.bit.spring.dao;

import com.bit.spring.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author james
 */
public interface PeliculaJPARepository extends JpaRepository<Pelicula, Integer>{
    
}
