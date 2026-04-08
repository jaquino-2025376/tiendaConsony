package com.tiendaConsony.controller;

import ch.qos.logback.core.model.Model;
import com.tiendaConsony.entity.Usuario;
import com.tiendaConsony.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username,
                                @RequestParam String contrasena,
                                Model model) {

        List<Usuario> usuarios = usuarioService.getAllUsuario();

        return username;
    }
    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio"; // inicio.html
}
}