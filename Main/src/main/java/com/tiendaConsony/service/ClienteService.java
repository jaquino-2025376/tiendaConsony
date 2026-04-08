package com.tiendaConsony.service;

import com.tiendaConsony.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    Cliente getClienteById(Integer id);
    Cliente saveCliente(Cliente cliente) throws RuntimeException;
    Cliente updateCliente(Integer id, Cliente cliente);
    void deleteCliente(Integer id);
}
