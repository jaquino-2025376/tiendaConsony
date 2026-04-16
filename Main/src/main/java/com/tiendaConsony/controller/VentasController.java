package com.tiendaConsony.controller;

import com.tiendaConsony.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentasController {

    private final VentaService service;

    public VentasController(VentaService service) {
        this.service = service;
    }

    @GetMapping("/venta")
    public String mostrarVentas(Model model) {
        model.addAttribute("ventas", service.getAllVenta());
        return "venta";
    }
}