package com.banco.bancobackend.repository;
import java.util.ArrayList;
import java.util.List;

import com.banco.bancobackend.model.Transferencia;

public class TransferenciaRepository {
    private List<Transferencia> clientes;

    public TransferenciaRepository() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Transferencia cliente) {
        clientes.add(cliente);
    }

    @SuppressWarnings("null")
	public TransferenciaRepository[] obtenerClientePorNombre(String nombre) {
        TransferenciaRepository[] transferencias = null;
		for (TransferenciaRepository cliente : transferencias) {
            if (cliente.getNombre().equals(nombre)) {
                return transferencias;
            }
        }
        return null;
    }

	private Object getNombre() {
		return null;
	}

}
