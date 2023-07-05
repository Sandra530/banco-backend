package com.banco.bancobackend.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banco.bancobackend.service.TransferenciaService;

@Controller
@RequestMapping("/transferencia")
public class TransferenciaController {
    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping("/realizar")
    @ResponseBody
    public String realizarTransferencia(@RequestBody TransferenciaService transferenciaRequest) {
        boolean transferenciaExitosa = transferenciaService.realizarTransferencia(
                transferenciaRequest.getNumeroCuentaOrigen(),
                transferenciaRequest.getNumeroCuentaDestino(),
                transferenciaRequest.getMonto()
        );

        if (transferenciaExitosa) {
            return "Transferencia exitosa";
        } else {
            return "Error en la transferencia";
        
    }
}
}
