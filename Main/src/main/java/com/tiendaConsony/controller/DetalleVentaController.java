package com.tiendaConsony.controller;

import com.tiendaConsony.entity.DetalleVenta;
import com.tiendaConsony.service.DetalleVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVenta> getAll() {
        return service.getAllDetalleVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getDetalleVentaById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity<>(service.saveDetalleVenta(detalleVenta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity<>(service.updateDetalleVenta(id, detalleVenta), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        service.deleteDetalleVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}