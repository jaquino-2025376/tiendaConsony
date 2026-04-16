package com.tiendaConsony.controller;

import com.tiendaConsony.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductosController {

    private final ProductoService service;

    public ProductosController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/producto")
    public String listarProductos(Model model){
        model.addAttribute("productos", service.getAllProducto());
        return "producto";
    }
}