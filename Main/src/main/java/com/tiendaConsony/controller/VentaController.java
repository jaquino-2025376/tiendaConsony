package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Venta;
import com.tiendaConsony.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Venta searchedVenta = service.getVentaById(id);
        return new ResponseEntity<>(searchedVenta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createVenta(@RequestBody Venta venta) {
        Venta createdVenta = service.saveVenta(venta);
        return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable int id, @RequestBody Venta venta) {
        Venta updatedVenta = service.updateVenta(id, venta);
        return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable int id) {
        service.deleteVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}