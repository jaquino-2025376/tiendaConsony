package com.tiendaConsony.service;

import com.tiendaConsony.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuario();
    Usuario getUsuarioById(Integer id);
    Usuario saveUsuario(Usuario usuario) throws RuntimeException;
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}