import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { clientes } from 'src/app/datos/usuarios-ejemplo';

@Component({
  selector: 'app-mi-perfil',
  templateUrl: './mi-perfil.component.html',
  styleUrls: ['./mi-perfil.component.css']
})
export class MiPerfilComponent implements OnInit {

cliente: any = null;

constructor(private clienteService: ClienteService){}



  ngOnInit(): void {
    this.cliente = this.clienteService.leerSesion();
    console.log("Logueado: ",this.cliente)
}

}
