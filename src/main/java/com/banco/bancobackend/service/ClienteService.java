package com.banco.bancobackend.service;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.repository.ClienteRepository;
import com.banco.bancobackend.repository.GestorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
