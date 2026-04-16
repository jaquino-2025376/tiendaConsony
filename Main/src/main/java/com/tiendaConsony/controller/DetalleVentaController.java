package com.tiendaConsony.controller;

import com.tiendaConsony.entity.DetalleVenta;
import com.tiendaConsony.service.DetalleVentaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<DetalleVenta> getAll() {
        return service.getAllDetalleVenta();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public DetalleVenta getById(@PathVariable Integer id) {
        return service.getDetalleVentaById(id);
    }

    @PostMapping
    @ResponseBody
    public DetalleVenta create(@RequestBody DetalleVenta detalleVenta) {
        return service.saveDetalleVenta(detalleVenta);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public DetalleVenta update(@PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {
        return service.updateDetalleVenta(id, detalleVenta);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.deleteDetalleVenta(id);
    }
}