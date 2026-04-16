package com.tiendaConsony.controller;

import com.tiendaConsony.service.DetalleVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetallesVentaController {

    private final DetalleVentaService service;

    public DetallesVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping("/detalleVenta")
    public String mostrarDetalleVentas(Model model){
        model.addAttribute("detalles", service.getAllDetalleVenta());
        return "detalleVenta";
    }
}