package com.tiendaConsony.service;

import com.tiendaConsony.entity.Cliente;
import com.tiendaConsony.exception.ResourceNotFoundException;
import com.tiendaConsony.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        return cliente;
    }

    @Override
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente){
        Cliente updateCliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
            updateCliente.setNombreCliente(cliente.getNombreCliente());
            updateCliente.setApellidoCliente(cliente.getApellidoCliente());
            updateCliente.setCorreoCliente(cliente.getCorreoCliente());
            updateCliente.setTelefonoCliente(cliente.getTelefonoCliente());
            updateCliente.setDireccionCliente(cliente.getDireccionCliente());
        }else{
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        return clienteRepository.save(updateCliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        clienteRepository.delete(cliente);
    }

}
