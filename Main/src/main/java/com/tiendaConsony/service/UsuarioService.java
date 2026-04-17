package com.tiendaConsony.service;

import com.tiendaConsony.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario registrar(String username, String contrasena);
    Usuario registrar(String username, String contrasena, String rol);
    Usuario login(String username, String contrasena);
    List<Usuario> listar();
    void eliminar(int id);
}
