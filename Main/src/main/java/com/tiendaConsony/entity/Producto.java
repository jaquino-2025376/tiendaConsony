package com.tiendaConsony.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer codigoProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "stock")
    private Integer stock;

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Float getPrecioProducto() {
        return precio;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precio = precioProducto;
    }

    public Integer getStockProducto() {
        return stock;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stock = stockProducto;
    }
}