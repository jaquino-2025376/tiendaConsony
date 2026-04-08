package com.tiendaConsony.controller;

import com.tiendaConsony.entity.Usuario;
import com.tiendaConsony.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return service.getAllUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable int id) {
        Usuario searchedUsuario = service.getUsuarioById(id);
        return new ResponseEntity<>(searchedUsuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = service.saveUsuario(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario updatedUsuario = service.updateUsuario(id, usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable int id) {
        service.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}