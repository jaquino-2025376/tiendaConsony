package com.tiendaConsony.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String mostrarInicio(Model model, HttpSession session) {
        model.addAttribute("usuarioSesion", session.getAttribute("usuarioSesion"));
        model.addAttribute("rolSesion",     session.getAttribute("rolSesion"));
        model.addAttribute("fotoSesion",    session.getAttribute("fotoSesion"));
        return "inicio";
    }
}
