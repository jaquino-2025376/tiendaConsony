package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Cliente;
import com.tiendaConsony.service.ClienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientesController {

    private final ClienteService service;

    public ClientesController(ClienteService service) {
        this.service = service;
    }

    private void sesion(HttpSession s, Model m) {
        m.addAttribute("usuarioSesion", s.getAttribute("usuarioSesion"));
        m.addAttribute("rolSesion",     s.getAttribute("rolSesion"));
        m.addAttribute("fotoSesion",    s.getAttribute("fotoSesion"));
    }

    @GetMapping("/cliente")
    public String listar(Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("clientes", service.getAllCliente());
        return "cliente";
    }

    @GetMapping("/agregarCliente")
    public String formAgregar(Model model, HttpSession session) {
        sesion(session, model);
        return "agregarCliente";
    }

    @PostMapping("/agregarCliente")
    public String guardar(@ModelAttribute Cliente cliente) {
        service.saveCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/editarCliente/{id}")
    public String formEditar(@PathVariable Integer id, Model model, HttpSession session) {
        sesion(session, model);
        model.addAttribute("cliente", service.getClienteById(id));
        return "editarCliente";
    }

    @PostMapping("/editarCliente/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Cliente cliente) {
        service.updateCliente(id, cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteCliente(id);
        return "redirect:/cliente";
    }
}
