package com.tiendaConsony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentasController {
    @GetMapping("/venta")
    public String mostrarVentas(){
        return "venta";
    }
}