import { Component } from '@angular/core';
import { transferenciasRecibidas } from 'src/app/datos/transferencias-ejemplo';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { TransferenciaService } from 'src/app/services/transferencias/transferencia.service';
@Component({
  selector: 'app-transferencias-recibidas',
  templateUrl: './transferencias-recibidas.component.html',
  styleUrls: ['./transferencias-recibidas.component.css']
})
export class TransferenciasRecibidasComponent {

  transferencias: any[] = [];
  cliente: any = null;



  constructor(private transferenciaService: TransferenciaService, private clienteService: ClienteService) { }



  ngOnInit() {
    
    this.cliente = this.clienteService.leerSesion();
    this.cargarTransferencias()
    console.log("Logueado: ", this.cliente)
  }

  cargarTransferencias(){
    const Beneficiario = this.cliente
    this.transferenciaService.obtenerTransferenciasRecibidas(Beneficiario.id).subscribe(
      (    transferenciasCargadas: any) => {
       this.transferencias= transferenciasCargadas;
  }
  )
  }



}
