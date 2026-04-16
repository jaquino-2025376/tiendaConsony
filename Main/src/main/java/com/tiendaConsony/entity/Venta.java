package com.tiendaConsony.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "total")
    private Double totalVenta;

    @Column(name = "clientes_codigo_cliente")
    private Integer fkCodigoCliente;

    @Column(name = "usuarios_codigo_usuario")
    private Integer fkCodigoUsuario;


    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Integer getFkCodigoCliente() {
        return fkCodigoCliente;
    }

    public void setFkCodigoCliente(Integer fkIdCliente) {
        this.fkCodigoCliente = fkIdCliente;
    }

    public Integer getFkCodigoUsuario() {
        return fkCodigoUsuario;
    }

    public void setFkCodigoUsuario(Integer fkIdUsuario) {
        this.fkCodigoUsuario = fkIdUsuario;
    }
}