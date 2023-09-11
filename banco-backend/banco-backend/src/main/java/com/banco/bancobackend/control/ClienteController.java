package com.banco.bancobackend.control;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.service.ClienteService;

@RestController
// http://localhost:8080/gestor
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping()
	public ArrayList<Cliente> obtenerClientes() {
		return this.clienteService.leerClientes();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Cliente> obtenerGestor(@PathVariable("id") Integer id) {
		return this.clienteService.leerClientePorId(id);
	}
	
	@GetMapping(path = "/correo/{email}")
	public Optional<Cliente> obtenerGestorPorCorreo(@PathVariable("email") String email) {
		return this.clienteService.buscarPorCorreo(email);
	}
	
	@GetMapping(path = "login")
	public Optional<Cliente> loguearGestor(@RequestParam("correo") String correo, @RequestParam("pass")String password) {
		return this.clienteService.buscarClientePorCorreoYPass(correo, password);
	}

	@PostMapping()
	public Cliente guardarGestor(@RequestBody Cliente cliente) {
		return this.clienteService.guardarCliente(cliente);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrarGestor(@PathVariable("id") Integer id) {
		this.clienteService.borrarClientePorId(id);
	}

}