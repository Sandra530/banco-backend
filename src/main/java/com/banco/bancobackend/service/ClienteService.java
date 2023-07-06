package com.banco.bancobackend.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public ArrayList<Cliente> leerClientes(){
		return (ArrayList<Cliente>) this.clienteRepository.findAll();
	}
	
	public Optional<Cliente> leerCliente (Long id) {
		return this.clienteRepository.findById(id);
	}
	
	public String obtenerPasswordActual (Cliente cliente) {
		Cliente clienteGuardado = leerCliente(cliente.getId()).orElse(null);
		if(clienteGuardado!=null) {
			return clienteGuardado.getPassword();
			
		}
		return null;
	}
	public Cliente guardarClienteSinActualizarPassword(Cliente cliente) {
		String passGuardada = obtenerPasswordActual(cliente);
		cliente.setPassword(passGuardada);
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		String pass = cliente.getPassword();
		if (pass !=null) {
			cliente.cifrarPassword();
		}else {
			String passGuardada = obtenerPasswordActual(cliente);
			if(passGuardada!=null) {
				cliente.setPassword(passGuardada);
			}
		}
		return this.clienteRepository.save(cliente);
		
	}
	public Optional<Cliente> obtenerConCorreo(String email) {
		return this.clienteRepository.findFirstByCorreo(email);
			}
	public Optional <Cliente> buscarClientePorCorreoYPass(String correo, String password){
		Optional<Cliente> cliente = obtenerConCorreo(correo);
		if(cliente.isPresent()) {
			Cliente clienteEncontrado = cliente.get();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, clienteEncontrado.getPassword())); {
				return cliente;
			}
		}
		return null;
	}
	
	
			
	public void borrarCliente(Long id ) {
		 this.clienteRepository.deleteById(id);
	
	
	
	
	
}
}


