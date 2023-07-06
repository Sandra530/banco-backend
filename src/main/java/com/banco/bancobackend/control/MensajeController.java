package com.banco.bancobackend.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Mensaje;
import com.banco.bancobackend.service.MensajeService;

@RestController
@RequestMapping("/mensaje")
@CrossOrigin(origins = "http://localhost:4200")
public class MensajeController {

	@Autowired
	private MensajeService mensajeService;

	@GetMapping
	public List<Mensaje> findAll() {
		return mensajeService.findAll();
	}

	@GetMapping("/{id}")
	public Mensaje findById(@PathVariable Long id) {
		return mensajeService.findById(id);
	}

	@PostMapping
	public Mensaje save(@RequestBody Mensaje mensaje) {
		return mensajeService.save(mensaje);
	}

	@PutMapping
	public Mensaje update(@RequestBody Mensaje mensaje) {
		return mensajeService.save(mensaje);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		mensajeService.deleteById(id);
	}
}