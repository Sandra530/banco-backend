package com.banco.bancobackend.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}