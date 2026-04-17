package com.tiendaConsony.controller;

import com.tiendaConsony.entity.DetalleVenta;
import com.tiendaConsony.service.DetalleVentaService;
import com.tiendaConsony.service.ProductoService;
import com.tiendaConsony.service.VentaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DetallesVentaController {

    private final DetalleVentaService service;
    private final ProductoService productoService;
    private final VentaService ventaService;

    public DetallesVentaController(DetalleVentaService service,
                                   ProductoService productoService,
                                   VentaService ventaService) {
        this.service         = service;
        this.productoService = productoService;
        this.ventaService    = ventaService;
    }

    private void sesion(HttpSession s, Model m) {
        m.addAttribute("usuarioSesion", s.getAttribute("usuarioSesion"));
        m.addAttribute("rolSesion",     s.getAttribute("rolSesion"));
        m.addAttribute("fotoSesion",    s.getAttribute("fotoSesion"));
    }

    @GetMapping("/detalleVenta")
    public String listar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("detalles", service.getAllDetalleVenta());
        return "detalleVenta";
    }

    @GetMapping("/agregarDetalleVenta")
    public String formAgregar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("productos", productoService.getAllProducto());
        model.addAttribute("ventas",    ventaService.getAllVenta());
        return "agregarDetalleVenta";
    }

    @PostMapping("/agregarDetalleVenta")
    public String guardar(@ModelAttribute DetalleVenta detalle) {
        service.saveDetalleVenta(detalle);
        return "redirect:/detalleVenta";
    }

    @GetMapping("/editarDetalleVenta/{id}")
    public String formEditar(@PathVariable int id, Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("detalle",   service.getDetalleVentaById(id));
        model.addAttribute("productos", productoService.getAllProducto());
        model.addAttribute("ventas",    ventaService.getAllVenta());
        return "editarDetalleVenta";
    }

    @PostMapping("/editarDetalleVenta/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute DetalleVenta detalle) {
        service.updateDetalleVenta(id, detalle);
        return "redirect:/detalleVenta";
    }

    @GetMapping("/eliminarDetalleVenta/{id}")
    public String eliminar(@PathVariable int id) {
        service.deleteDetalleVenta(id);
        return "redirect:/detalleVenta";
    }
}
