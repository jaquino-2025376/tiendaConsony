package com.tiendaConsony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class InicioController {
    @GetMapping
    public String mostrarInicio(){
        return "inicio";
    }

    @GetMapping("/inicio-cliente")
    public String mostrarCliente(){
        return "cliente";
    }

    @GetMapping("/cerrar-sesion")
    public String cerrarSesion(){
        return ("redirect:/login");
    }
}

