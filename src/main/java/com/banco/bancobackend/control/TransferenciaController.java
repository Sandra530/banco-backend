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

import com.banco.bancobackend.model.Transferencia;
import com.banco.bancobackend.service.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@GetMapping
	public List<Transferencia> findAll() {
		return transferenciaService.findAll();
	}

	@GetMapping("/{id}")
	public Transferencia findById(@PathVariable Long id) {
		return transferenciaService.findById(id);
	}

	@PostMapping
	public Transferencia save(@RequestBody Transferencia transferencia) {
		return transferenciaService.save(transferencia);
	}

	@PutMapping
	public Transferencia update(@RequestBody Transferencia transferencia) {
		return transferenciaService.save(transferencia);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		transferenciaService.deleteById(id);
	}

	
	@GetMapping("/ordenante/{id}")
	public List<Transferencia> getTransferenciasEnviadas(@PathVariable Long id) {
		return transferenciaService.getTransferenciasByClienteOrdenante(id);
	}
	@GetMapping("/beneficiario/{id}")
	public List<Transferencia> getTransferenciasRecibidas(@PathVariable Long id) {
		return transferenciaService.getTransferenciasByClienteBeneficiario(id);
	}

}
