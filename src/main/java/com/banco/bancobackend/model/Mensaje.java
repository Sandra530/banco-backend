package com.banco.bancobackend.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "origen_id", nullable = false)
	private Gestor origen;

	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Gestor destino;

	@Column(nullable = false)
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@PrePersist
	protected void onCreate() {
		this.fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gestor getOrigen() {
		return origen;
	}

	public void setOrigen(Gestor origen) {
		this.origen = origen;
	}

	public Gestor getDestino() {
		return destino;
	}

	public void setDestino(Gestor destino) {
		this.destino = destino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
