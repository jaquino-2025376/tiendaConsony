package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Venta;
import com.tiendaConsony.service.ClienteService;
import com.tiendaConsony.service.UsuarioService;
import com.tiendaConsony.service.VentaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VentasController {

    private final VentaService ventaService;
    private final ClienteService clienteService;
    private final UsuarioService usuarioService;

    public VentasController(VentaService ventaService,
                            ClienteService clienteService,
                            UsuarioService usuarioService) {
        this.ventaService   = ventaService;
        this.clienteService = clienteService;
        this.usuarioService = usuarioService;
    }

    private void sesion(HttpSession s, Model m) {
        m.addAttribute("usuarioSesion", s.getAttribute("usuarioSesion"));
        m.addAttribute("rolSesion",     s.getAttribute("rolSesion"));
        m.addAttribute("fotoSesion",    s.getAttribute("fotoSesion"));
    }

    @GetMapping("/venta")
    public String listar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("ventas", ventaService.getAllVenta());
        return "venta";
    }

    @GetMapping("/agregarVenta")
    public String formAgregar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("clientes", clienteService.getAllCliente());
        model.addAttribute("usuarios", usuarioService.listar());
        return "agregarVenta";
    }

    @PostMapping("/agregarVenta")
    public String guardar(@ModelAttribute Venta venta) {
        ventaService.saveVenta(venta);
        return "redirect:/venta";
    }

    @GetMapping("/editarVenta/{id}")
    public String formEditar(@PathVariable int id, Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("venta",    ventaService.getVentaById(id));
        model.addAttribute("clientes", clienteService.getAllCliente());
        model.addAttribute("usuarios", usuarioService.listar());
        return "editarVenta";
    }

    @PostMapping("/editarVenta/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Venta venta) {
        ventaService.updateVenta(id, venta);
        return "redirect:/venta";
    }

    @GetMapping("/eliminarVenta/{id}")
    public String eliminar(@PathVariable int id) {
        ventaService.deleteVenta(id);
        return "redirect:/venta";
    }
}
