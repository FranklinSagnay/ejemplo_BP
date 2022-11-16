package com.bit.spring.controller;

import com.bit.spring.dao.PeliculaJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author james
 */
@Controller
public class CursoController {

    @Value("${curso.msg.catalogo}")
    private String mensaje;
    @Autowired
    private PeliculaJPARepository repositorio;

    @RequestMapping("/home")
    public String home(Model modelo) {
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("catalogo", repositorio.findAll());
        return "home";
    }

    @RequestMapping()
    public String peticion(Model modelo) {
        modelo.addAttribute("mensaje", mensaje);
        return "index";
    }

}
