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

    @Column(name = "total_venta")
    private Double totalVenta;

    @Column(name = "fk_id_cliente")
    private Integer fkIdCliente;

    @Column(name = "fk_id_usuario")
    private Integer fkIdUsuario;


    public Integer getIdVenta() {
        return codigoVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.codigoVenta = idVenta;
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

    public Integer getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(Integer fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public Integer getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Integer fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }
}