package com.banco.bancobackend.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Transferencia;
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	List<Transferencia> findByOrdenanteId(Long id);
	
}
