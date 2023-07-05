package com.banco.bancobackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Integer id;
	
	private String usuario;
	
	private String correo;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private Double saldo;

	@ManyToOne
	private Gestor gestor;
	public Cliente () {
		
	}
	
	
	public Integer getId() {
		return id;
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Gestor getGestor() {
		return gestor;
	}
	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
