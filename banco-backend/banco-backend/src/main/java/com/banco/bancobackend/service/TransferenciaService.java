package com.banco.bancobackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.model.Transferencia;
import com.banco.bancobackend.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

@Autowired
TransferenciaRepository transferenciaRepository;

@Autowired
ClienteService clienteService;

public ArrayList<Transferencia> leerTransferencia() {
return (ArrayList<Transferencia>) this.transferenciaRepository.findAll();
}

// obtener un gestor por su id
public Optional<Transferencia> leerTransferenciaPorId(Integer id){
return this.transferenciaRepository.findById(id);
}

// guarda (crea o actualiza) un gestor
public Transferencia guardarTransferencia(Transferencia transferencia) {
Cliente clienteOrdenante = clienteService.leerClientePorId(transferencia.getClienteOrdenante().getId()).orElse(null);
Cliente clienteBeneficiario = clienteService.leerClientePorId(transferencia.getClienteBeneficiario().getId()).orElse(null);
clienteOrdenante.setSaldo(clienteOrdenante.getSaldo()-transferencia.getImporte());
clienteBeneficiario.setSaldo(clienteBeneficiario.getSaldo()+transferencia.getImporte());

 this.transferenciaRepository.save(transferencia);

clienteService.guardarClientesinActualizarPassword(clienteOrdenante);
clienteService.guardarClientesinActualizarPassword(clienteBeneficiario);

return transferencia;
}

// elimina un gestor por su id
public void borrarTransferenciaPorId(Integer id) {
this.transferenciaRepository.deleteById(id);
}

public Optional<Transferencia> buscarTransferenciaPorFecha(Date fecha) {
// TODO Auto-generated method stub
return this.transferenciaRepository.findFirstByFecha(fecha);
}

public ArrayList<Transferencia> buscarTransferenciaEnviada(Integer idCliente) {
	Cliente cliente = clienteService.leerClientePorId(idCliente).orElse(null);
	if(cliente == null) {
		return null;
	}
	return transferenciaRepository.findByClienteOrdenante(cliente);
}

public ArrayList<Transferencia> buscarTransferenciaRecibidas(Integer idCliente) {
	Cliente cliente = clienteService.leerClientePorId(idCliente).orElse(null);
	if(cliente == null) {
		return null;
	}
	return transferenciaRepository.findByClienteBeneficiario(cliente);
}
}


