package com.tiendaConsony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetallesVentaController {
    @GetMapping("/detalleVentas")
    public String mostrarDetalleVentas(){
        return "detalleVentas";
    }
}