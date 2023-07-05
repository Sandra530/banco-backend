package com.banco.bancobackend.control;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.banco.bancobackend.model.Cliente;

public class ClienteController {
	
	
 Object clienteRepository;

	public Optional <Cliente> obtenerConCorreo(String email){
		return this.clienteRepository.findFirstByCorreo(email);
	}
	public Optional <Cliente> buscarClientePorCorreoYPass(String correo, String password) {
		Optional <Cliente> cliente = obtenerConCorreo(correo);
		if (cliente.isPresent()) {
			Cliente clienteEncontrado = cliente.get();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, clienteEncontrado.getPassword()));{
			return cliente;
		}
	}
	return null;
	
	

}

}
