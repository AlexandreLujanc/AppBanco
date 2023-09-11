package com.banco.bancobackend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Transferencia {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@ManyToOne
private Cliente clienteOrdenante;
@ManyToOne
private Cliente clienteBeneficiario;
private Double importe;
private String concepto;
private Date fecha;
public Integer getId() {
return id;
}
public void setId(Integer id) {
this.id = id;
}

@PrePersist
private void antesDeGuardar() {
this.fecha = new Date();
}

public Cliente getClienteOrdenante() {
return clienteOrdenante;
}
public void setClienteOrdenante(Cliente clienteOrdenante) {
this.clienteOrdenante = clienteOrdenante;
}
public Cliente getClienteBeneficiario() {
return clienteBeneficiario;
}
public void setClienteBeneficiario(Cliente clienteBeneficiario) {
this.clienteBeneficiario = clienteBeneficiario;
}
public Double getImporte() {
return importe;
}
public void setImporte(Double importe) {
this.importe = importe;
}
public String getConcepto() {
return concepto;
}
public void setConcepto(String concepto) {
this.concepto = concepto;
}
public Date getFecha() {
return fecha;
}
public void setFecha(Date fecha) {
this.fecha = fecha;
}


}