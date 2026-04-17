package com.tiendaConsony.service;

import com.tiendaConsony.entity.Usuario;
import com.tiendaConsony.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImplements(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario registrar(String username, String contrasena) {
        return registrar(username, contrasena, "VENDEDOR");
    }

    @Override
    public Usuario registrar(String username, String contrasena, String rol) {
        if (repository.findByUsername(username) != null) {
            return null;
        }
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setContrasena(contrasena);
        u.setRol(rol != null ? rol : "VENDEDOR");
        return repository.save(u);
    }

    @Override
    public Usuario login(String username, String contrasena) {
        Usuario u = repository.findByUsername(username);
        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminar(int id) {
        repository.deleteById(id);
    }
}
