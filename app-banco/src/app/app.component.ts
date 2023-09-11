import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SesionService } from 'src/app/services/sesion-services.service';
import { ClienteService } from './services/cliente/cliente.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-banco';

  constructor(
    private router: Router,
    private sesionService: SesionService,
    private clienteService: ClienteService
  ) {}

  cerrarSesion() {
    this.clienteService.cerrarSesion();
    this.router.navigateByUrl('/auth/login');
  }

  getSesionIniciada() {
    return this.sesionService.getSesionIniciada();
  }



}



