package com.banco.bancobackend.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.bancobackend.model.Cliente;
import com.banco.bancobackend.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository <Transferencia, Integer> {

Optional<Transferencia> findFirstByFecha(Date fecha);
ArrayList<Transferencia>  findByClienteOrdenante(Cliente cliente);
ArrayList<Transferencia> findByClienteBeneficiario(Cliente cliente);

}