import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SesionService {
  private sesionIniciada = false;

  constructor() {}

  iniciarSesion() {
    this.sesionIniciada = true;
  }

  cerrarSesion() {
    this.sesionIniciada = false;
  }

  getSesionIniciada() {
    return this.sesionIniciada;
  }
}
