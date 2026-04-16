package com.tiendaConsony.controller;

import com.tiendaConsony.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {

        private final ClienteService service;

        public ClientesController(ClienteService service) {
            this.service = service;
        }

        @GetMapping("/cliente")
        public String listarClientes(Model model){
            model.addAttribute("clientes", service.getAllCliente());
            return "cliente";
        }
    }
