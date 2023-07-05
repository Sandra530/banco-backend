package com.banco.bancobackend.service;
import org.springframework.stereotype.Service;


import com.banco.bancobackend.model.Transferencia;

@Service
public class TransferenciaService {
    private TransferenciaService transferenciaService;

    public TransferenciaService(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    public boolean realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) {
        Transferencia cuentaOrigen = transferenciaService.obtenerCuentaPorNumero(numeroCuentaOrigen);
        Transferencia cuentaDestino = transferenciaService.obtenerCuentaPorNumero(numeroCuentaDestino);

        if (cuentaOrigen != null && cuentaDestino != null && cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
            return true; 
        } else {
            return false; 
        }
    }

	private Transferencia obtenerCuentaPorNumero(String numeroCuentaOrigen) {
		return null;
	

		
	}

	public String getNumeroCuentaOrigen() {
		return null;
	}

	public String getNumeroCuentaDestino() {
		return null;
	}

	public double getMonto() {
		return 0;
	}
}


