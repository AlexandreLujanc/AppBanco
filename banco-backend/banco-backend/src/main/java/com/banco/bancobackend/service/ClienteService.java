package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public ArrayList<Cliente> leerClientes(){
		return (ArrayList<Cliente>) this.clienteRepository.findAll();
	}
	
	public Optional<Cliente> leerClientePorId(Integer id){
		return this.clienteRepository.findById(id);
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		String pass= cliente.getPassword();
		if(pass!=null) {
			cliente.cifrarPassword();
		}else {
			cliente.setPassword(obtenerPasswordActual(cliente));
		
	}
	
		return this.clienteRepository.save(cliente);
	}
	
	private String obtenerPasswordActual(Cliente cliente) {
		Cliente clienteGuardado = leerClientePorId(cliente.getId()).orElse(null);
		if (clienteGuardado!= null) {
			return clienteGuardado.getPassword();
		}
		return null;
	}
	
	public void borrarClientePorId(Integer id) {
		this.clienteRepository.deleteById(id);
	}
	
	public Optional<Cliente> buscarPorCorreo(String correo){
		return this.clienteRepository.findFirstByCorreo(correo);
	}
	
	public Optional<Cliente> buscarClientePorCorreoYPass(String correo, String password){
		Optional<Cliente> cliente = buscarPorCorreo(correo);
		if (cliente.isPresent()) {
			Cliente clienteEncontrado = cliente.get();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, clienteEncontrado.getPassword())) {
			return cliente;
		}
		
	}
	return null;
}
	
	public Cliente guardarClientesinActualizarPassword (Cliente cliente) {
		String passGuardada = obtenerPasswordActual (cliente);
		cliente.setPassword(passGuardada);
		return this.clienteRepository.save(cliente);
	}
	
}





