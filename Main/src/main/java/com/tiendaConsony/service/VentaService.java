package com.tiendaConsony.service;

import com.tiendaConsony.entity.Venta;
import java.util.List;

public interface VentaService {
    List<Venta> getAllVenta();
    Venta getVentaById(Integer id);
    Venta saveVenta(Venta venta);
    Venta updateVenta(Integer id, Venta venta);
    void deleteVenta(Integer id);
}