package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Gestor;
import com.banco.bancobackend.repository.GestorRepository;

@Service
public class GestorService {

	@Autowired
	GestorRepository gestorRepository;
	
	public ArrayList<Gestor> leerGestores(){
		return (ArrayList<Gestor>) this.gestorRepository.findAll();
	}
	
	public Optional<Gestor> leerGestorPorId(Integer id){
		return this.gestorRepository.findById(id);
	}
	
	public Gestor guardarGestor(Gestor gestor) {
		return this.gestorRepository.save(gestor);
	}
	
	public void borrarGestorPorId(Integer id) {
		this.gestorRepository.deleteById(id);
	}
	
	public Optional<Gestor> buscarPorCorreo(String correo){
		return this.gestorRepository.findFirstByCorreo(correo);
	}
	
	public Optional<Gestor> buscarGestorPorCorreoYPass(String correo, String password){
		return this.gestorRepository.findFirstByCorreoAndPassword(correo , password);
	}
}
