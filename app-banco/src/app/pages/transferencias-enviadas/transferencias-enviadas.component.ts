import { Component} from '@angular/core';
import { transferenciasEnviadas } from 'src/app/datos/transferencias-ejemplo';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { TransferenciaService } from 'src/app/services/transferencias/transferencia.service';

@Component({
  selector: 'app-transferencias-enviadas',
  templateUrl: './transferencias-enviadas.component.html',
  styleUrls: ['./transferencias-enviadas.component.css']
})
export class TransferenciasEnviadasComponent{

  transferencias: any[] = [];
  cliente: any = null;

  constructor(private transferenciaService: TransferenciaService, private clienteService: ClienteService){}

ngOnInit(){
  this.cliente = this.clienteService.leerSesion();
  this.cargarTransferencias()
    console.log("Logueado: ",this.cliente)
};

cargarTransferencias(){
  const Ordenante = this.cliente
  this.transferenciaService.obtenerTransferenciasEnviadas(Ordenante.id).subscribe(
    (    transferenciasCargadas: any) => {
     this.transferencias= transferenciasCargadas;
}
)
}


}
