package com.banco.bancobackend.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
	@PostMapping("/login")
	public ResponseEntity<Cliente> login(@RequestBody Cliente cliente) {
		Optional<Cliente> optCliente = clienteService.login(cliente.getCorreo(), cliente.getPassword());
		if (optCliente.isPresent()) {
			// responde con 200 OK
			return ResponseEntity.ok(optCliente.get());
		} else {
			// no recibiremos null, tendremos que tenerlo en cuenta
			return ResponseEntity.status(401).build();
		}
	}
}