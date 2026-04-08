package com.tiendaConsony.service;

import com.tiendaConsony.entity.DetalleVenta;
import com.tiendaConsony.exception.ResourceNotFoundException;
import com.tiendaConsony.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {

    private final DetalleVentaRepository repository;

    public DetalleVentaServiceImplements(DetalleVentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle venta no encontrado"));
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        return repository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle venta no encontrado"));

        existente.setCantidad(detalleVenta.getCantidad());
        existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        existente.setSubtotal(detalleVenta.getSubtotal());
        existente.setProductoId(detalleVenta.getProductoId());
        existente.setVentaId(detalleVenta.getVentaId());

        return repository.save(existente);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        DetalleVenta existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle venta no encontrado"));

        repository.delete(existente);
    }
}