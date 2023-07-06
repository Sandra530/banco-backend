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
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ordenante_id", nullable = false)
	private Cliente ordenante;

	@ManyToOne
	@JoinColumn(name = "beneficiario_id", nullable = false)
	private Cliente beneficiario;

	@Column(nullable = false)
	private String concepto;

	@Column(nullable = false)
	private Double importe;

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

	public Cliente getOrdenante() {
		return ordenante;
	}

	public void setOrdenante(Cliente ordenante) {
		this.ordenante = ordenante;
	}

	public Cliente getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Cliente beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}