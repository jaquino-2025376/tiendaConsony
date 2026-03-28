package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Producto;
import com.tiendaConsony.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProducto(){
        return productoService.getAllProducto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductoById(@PathVariable int id){
        Producto searchedProducto = productoService.getProductoById(id);
        return new ResponseEntity<>(searchedProducto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createProducto(@RequestBody Producto producto){
        Producto createdProducto = productoService.saveProducto(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable int id, @RequestBody Producto producto){
        Producto updatedProducto = productoService.updateProducto(id, producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable int id){
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}