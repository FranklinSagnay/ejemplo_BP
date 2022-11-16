package com.bit.spring;

import com.bit.spring.dao.PeliculaJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author james
 */
@Component
public class ConsolaTest implements CommandLineRunner{
    
    @Autowired
    private PeliculaJPARepository repositorio;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=============================");
        System.out.println("POR LINEA DE COMANDOS  " + repositorio);
        repositorio.findAll().stream().forEach(o -> System.out.println(">> " + o));        
    }
    
}
