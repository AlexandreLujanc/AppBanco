package com.banco.bancobackend.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
	
	
	public Optional<Mensaje> findFirstByFecha(Date fecha);
	
	public ArrayList<Mensaje> findByGestorOrigenId(Integer gestorOrigen);
	
	public ArrayList<Mensaje> findByGestorDestinoId(Integer gestorDestino);

}