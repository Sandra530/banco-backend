package com.banco.bancobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Mensaje;
import com.banco.bancobackend.repository.MensajeRepository;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    public Mensaje findById(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    public Mensaje save(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    public void deleteById(Long id) {
        mensajeRepository.deleteById(id);
    }
}
