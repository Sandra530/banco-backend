package com.banco.bancobackend.service;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.repository.ClienteRepository;
import com.banco.bancobackend.repository.GestorRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class ClienteService {
	
	public Cliente guardarCliente(Cliente cliente) {
		String pass = cliente.getPassword();
		if (pass !=null) {
		}else {
			String passGuardada = obtenerPasswordActual(cliente);
			if(passGuardada!=null);
			cliente.setPassword(passGuardada);
			}
		
	return this.clienteRepository.save(cliente);
	}


	private String obtenerPasswordActual(Cliente cliente) {
	Cliente clienteGuardado = leerCliente(cliente.getId()).orElse(null);
	if(clienteGuardado !=null) {
		return clienteGuardado.getPassword();
	}
	return null;
}
	public Cliente guardarClienteSinActualizarPassword(Cliente cliente) {
		String passGuardada = obtenerPasswordActual(cliente);
		cliente.setPassword(passGuardada);
		return this.clienteRepository.save(cliente);
	}


	public Optional<Cliente> obtenerConCorreo(String email) {
	return this.ClienteRepository.findFirstByCorreo(email);
}
	public Optional<Cliente> buscarClientePorCorreoYPass(String correo, String password){
		Optional<Cliente> cliente = obtenerConCorreo(correo);
		if (cliente.isPresent()) {
			Cliente clienteEncontrado = cliente.get();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, clienteEncontrado.getPassword())) {
				return cliente;
			}
		}
		return null;
	}
	
	



public static Object leerCliente(Integer id) {
	return null;
}
	}


    

    
