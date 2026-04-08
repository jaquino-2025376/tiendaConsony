package com.tiendaConsony.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Página raíz: redirige a /login
    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // nombre de tu HTML Thymeleaf: login.html
    }

    // Procesar login
    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        String userCorrecto = "admin";
        String passwordCorrecto = "1234";

        if (usuario.equals(userCorrecto) && password.equals(passwordCorrecto)) {
            // Guardar sesión
            session.setAttribute("usuarioLogeado", usuario);
            return "redirect:/home-login";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrecta");
            return "login"; // regresar al login con error
        }
    }

    // Página protegida
    @GetMapping("/home-login")
    public String mostrarHome(HttpSession session) {
        if (session.getAttribute("usuarioLogeado") == null) {
            return "redirect:/login";
        }
        return "inicio"; // nombre de tu página después de login
    }
}