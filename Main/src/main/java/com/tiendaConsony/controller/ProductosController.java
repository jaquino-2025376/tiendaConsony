package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Producto;
import com.tiendaConsony.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductosController {

    private final ProductoService service;

    public ProductosController(ProductoService service) {
        this.service = service;
    }

    private void sesion(HttpSession s, Model m) {
        m.addAttribute("usuarioSesion", s.getAttribute("usuarioSesion"));
        m.addAttribute("rolSesion",     s.getAttribute("rolSesion"));
        m.addAttribute("fotoSesion",    s.getAttribute("fotoSesion"));
    }

    @GetMapping("/producto")
    public String listar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("productos", service.getAllProducto());
        return "producto";
    }

    @GetMapping("/agregarProducto")
    public String formAgregar(Model model, HttpSession session) {
        sesion(session, model);
        return "agregarProducto";
    }

    @PostMapping("/agregarProducto")
    public String guardar(@ModelAttribute Producto producto) {
        service.saveProducto(producto);
        return "redirect:/producto";
    }

    @GetMapping("/editarProducto/{id}")
    public String formEditar(@PathVariable int id, Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("producto", service.getProductoById(id));
        return "editarProducto";
    }

    @PostMapping("/editarProducto/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Producto producto) {
        service.updateProducto(id, producto);
        return "redirect:/producto";
    }

    @GetMapping("/eliminarProducto/{id}")
    public String eliminar(@PathVariable int id) {
        service.deleteProducto(id);
        return "redirect:/producto";
    }
}
