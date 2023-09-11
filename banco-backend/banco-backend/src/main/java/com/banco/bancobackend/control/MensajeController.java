package com.banco.bancobackend.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Mensaje;
import com.banco.bancobackend.service.MensajeService;

@RestController
// http://localhost:8080/gestor
@RequestMapping("/mensaje")
@CrossOrigin(origins = "http://localhost:4200")
public class MensajeController {

	@Autowired
	MensajeService mensajeService;

	@GetMapping()
	public ArrayList<Mensaje> obtenerMensajes() {
		return this.mensajeService.leerMensajes();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Mensaje> obtenerMensajePorId(@PathVariable("id") Integer id) {
		return this.mensajeService.leerMensajePorId(id);
	}
	
	@GetMapping(path = "/fecha/{fecha}")
	public Optional<Mensaje> obtenerMensajePorFecha(@PathVariable("fecha") Date fecha) {
		return this.mensajeService.buscarPorFecha(fecha);
	}
	
	@GetMapping(path = "/origen/{gestorOrigen}")
	public ArrayList<Mensaje> obtenerMensajePorIdOrigen(@PathVariable("gestorOrigen") Integer gestorOrigen) {
		return this.mensajeService.buscarPorIdOrigen(gestorOrigen);
	}
	
	@GetMapping(path = "/destino/{gestorDestino}")
	public ArrayList<Mensaje> obtenerMensajePorIdDestino(@PathVariable("gestorDestino") Integer gestorDestino) {
		return this.mensajeService.buscarPorIdDestino(gestorDestino);
	}
	
	@PostMapping()
	public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
		return this.mensajeService.guardarMensaje(mensaje);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarMensaje(@PathVariable("id") Integer id) {
		this.mensajeService.borrarMensajePorId(id);
	}
	
}