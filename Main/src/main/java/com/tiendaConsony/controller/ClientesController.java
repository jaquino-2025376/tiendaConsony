package com.tiendaConsony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClientesController {
    @GetMapping
    public String mostrarCliente(){
        return "cliente";
    }
}