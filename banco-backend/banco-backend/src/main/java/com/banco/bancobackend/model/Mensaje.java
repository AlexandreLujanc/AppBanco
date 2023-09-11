package com.banco.bancobackend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity

public class Mensaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Gestor gestorOrigen;
	@ManyToOne
	private Gestor gestorDestino;
	
	private String texto;
	private Date fecha;
	
	@PrePersist
	private void antesDeGuardar() {
		if(this.fecha==null) {
		this.fecha= new Date();
		}
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Gestor getGestorOrigen() {
		return gestorOrigen;
	}
	public void setGestorOrigen(Gestor gestorOrigen) {
		this.gestorOrigen = gestorOrigen;
	}
	public Gestor getGestorDestino() {
		return gestorDestino;
	}
	public void setGestorDestino(Gestor gestorDestino) {
		this.gestorDestino = gestorDestino;
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