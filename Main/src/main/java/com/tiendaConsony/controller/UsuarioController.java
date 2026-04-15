package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Usuario;
import com.tiendaConsony.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String username,
                          @RequestParam String contrasena,
                          Model model) {

        Usuario u = service.login(username, contrasena);

        if (u != null) {
            return "redirect:/inicio";
        } else {
            model.addAttribute("error", "Credenciales Incorrectas");
            return "login";
        }
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String username,
                          @RequestParam String contrasena,
                          Model model) {

        Usuario u = service.registrar(username, contrasena);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existente");
            return "registro";
        }

        return "redirect:/login";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        List<Usuario> lista = service.listar();
        model.addAttribute("usuarios", lista);
        return "listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/lista";
    }
}