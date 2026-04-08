package com.tiendaConsony.service;

import com.tiendaConsony.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProducto();
    Producto getProductoById(Integer id);
    Producto saveProducto(Producto producto) throws RuntimeException;
    Producto updateProducto(Integer id, Producto producto);
    void deleteProducto(Integer id);
}
