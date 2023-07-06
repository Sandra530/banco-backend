package com.banco.bancobackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Mensaje;


public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
	}

