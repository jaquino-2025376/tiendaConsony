package com.tiendaConsony.service;

import com.tiendaConsony.entity.Producto;
import com.tiendaConsony.exception.ResourceNotFoundException;
import com.tiendaConsony.repository.ProductoRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImplements(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto == null){
            throw new ResourceNotFoundException("Producto no encontrado");
        }
        return producto;
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Integer id, Producto producto) {
    Producto updateProducto = productoRepository.findById(id).orElse(null);
    if (producto == null){
        updateProducto.setNombreProducto(producto.getNombreProducto());
        updateProducto.setPrecioProducto(producto.getPrecioProducto());
        updateProducto.setStockProducto(producto.getStockProducto());
    }else{
        throw new ResourceNotFoundException("Producto no encontrado");
    }
    return productoRepository.save(updateProducto);
    }

    @Override
    public void deleteProducto(Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null){
            throw new ResourceNotFoundException("Producto no encontrado");
        }
        productoRepository.delete(producto);
    }
}