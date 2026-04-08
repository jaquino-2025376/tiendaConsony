package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Cliente;
import com.tiendaConsony.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return service.getAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable int id) {
        Cliente searchedCliente = service.getClienteById(id);
        return new ResponseEntity<>(searchedCliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = service.saveCliente(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = service.updateCliente(id, cliente);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable int id) {
        service.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}