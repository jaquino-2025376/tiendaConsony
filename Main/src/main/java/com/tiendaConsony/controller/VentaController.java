package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Venta;
import com.tiendaConsony.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return service.getAllVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable int id) {
        return new ResponseEntity<>(service.getVentaById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@RequestBody Venta venta) {
        return new ResponseEntity<>(service.saveVenta(venta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable int id, @RequestBody Venta venta) {
        return new ResponseEntity<>(service.updateVenta(id, venta), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable int id) {
        service.deleteVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}