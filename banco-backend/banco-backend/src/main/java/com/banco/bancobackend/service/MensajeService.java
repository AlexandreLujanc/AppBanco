package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Mensaje;
import com.banco.bancobackend.repository.MensajeRepository;

@Service
public class MensajeService {

	@Autowired
	MensajeRepository mensajeRepository;
	
	public ArrayList<Mensaje> leerMensajes(){
		return (ArrayList<Mensaje>) this.mensajeRepository.findAll();
	}
	
	public Optional<Mensaje> leerMensajePorId(Integer id){
		return this.mensajeRepository.findById(id);
	}
	
	public Mensaje guardarMensaje(Mensaje mensaje) {
		return this.mensajeRepository.save(mensaje);
	}
	
	public void borrarMensajePorId(Integer id) {
		this.mensajeRepository.deleteById(id);
	}
	
	public Optional<Mensaje> buscarPorFecha(Date fecha){
		return this.mensajeRepository.findFirstByFecha(fecha);
	}

	public ArrayList<Mensaje> buscarPorIdOrigen(Integer gestorOrigen) {
		
		return this.mensajeRepository.findByGestorOrigenId(gestorOrigen);
	}

	public ArrayList<Mensaje> buscarPorIdDestino(Integer gestorDestino) {
		// TODO Auto-generated method stub
		return this.mensajeRepository.findByGestorDestinoId(gestorDestino);
	}
	

}
