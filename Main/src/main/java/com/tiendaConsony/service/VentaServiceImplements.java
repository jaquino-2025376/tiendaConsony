package com.tiendaConsony.service;

import com.tiendaConsony.entity.Venta;
import com.tiendaConsony.exception.ResourceNotFoundException;
import com.tiendaConsony.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImplements(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) {
            throw new ResourceNotFoundException("Venta no encontrada");
        }
        return venta;
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer id, Venta venta) {
        Venta updateVenta = ventaRepository.findById(id).orElse(null);

        if (updateVenta == null) {
            throw new ResourceNotFoundException("Venta no encontrada");
        }

        updateVenta.setFechaVenta(venta.getFechaVenta());
        updateVenta.setTotalVenta(venta.getTotalVenta());
        updateVenta.setFkIdCliente(venta.getFkIdCliente());
        updateVenta.setFkIdUsuario(venta.getFkIdUsuario());

        return ventaRepository.save(updateVenta);
    }

    @Override
    public void deleteVenta(Integer id) {
        Venta venta = ventaRepository.findById(id).orElse(null);

        if (venta == null) {
            throw new ResourceNotFoundException("Venta no encontrada");
        }

        ventaRepository.delete(venta);
    }
}