package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Usuario;
import com.tiendaConsony.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
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
                          HttpSession session,
                          Model model) {

        Usuario u = service.login(username, contrasena);

        if (u != null) {
            session.setAttribute("usuarioSesion", u);
            session.setAttribute("rolSesion",     u.getRol() != null ? u.getRol() : "SIN ROL");
            session.setAttribute("fotoSesion",    u.getUsername() + ".jpg");
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
                          @RequestParam(required = false, defaultValue = "VENDEDOR") String rol,
                          Model model) {

        Usuario u = service.registrar(username, contrasena, rol);
        if (u == null) {
            model.addAttribute("error", "Usuario ya existente");
            return "registro";
        }
        return "redirect:/login";
    }

    @GetMapping("/lista")
    public String listar(Model model, HttpSession session) {
        model.addAttribute("usuarios",      service.listar());
        model.addAttribute("usuarioSesion", session.getAttribute("usuarioSesion"));
        model.addAttribute("rolSesion",     session.getAttribute("rolSesion"));
        model.addAttribute("fotoSesion",    session.getAttribute("fotoSesion"));
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/lista";
    }
}
