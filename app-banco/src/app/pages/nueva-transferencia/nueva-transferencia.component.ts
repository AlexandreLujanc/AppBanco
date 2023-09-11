import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { TransferenciaService } from 'src/app/services/transferencias/transferencia.service';

@Component({
  selector: 'app-nueva-transferencia',
  templateUrl: './nueva-transferencia.component.html',
  styleUrls: ['./nueva-transferencia.component.css']
})
export class NuevaTransferenciaComponent implements OnInit {
nuevaTransferencia: any ={
  clienteOrdenante: {id: null,},
  clienteBeneficiario: {id: null,},
  concepto: "",
  importe: 0,

};
cliente: any = null;

ordenante: any = null;

feedback: string = "";

  constructor(private transferenciaService: TransferenciaService, private clienteService: ClienteService) { }


  enviarTransferencia() {
    if (this.ordenante) {
      this.nuevaTransferencia.clienteOrdenante.id = this.ordenante.id;
      this.transferenciaService
        .crearTransferencia(this.nuevaTransferencia)
        .subscribe(
          (transferenciaGuardada: any) => {
            console.log({ transferenciaGuardada });
            this.feedback = "Transferencia enviada con éxito";
          },
          (error) => {
            console.log(error);
            this.feedback = "Error al enviar la transferencia";
          }
        );
        
      this.ordenante = '';
      this.Beneficiario = null;
      this.Concepto = '';
      this.Importe = 0;
    }
  }
  

  ngOnInit(): void {
    this.ordenante = this.clienteService.leerSesion();
    this.cliente = this.clienteService.leerSesion();
  }

  Beneficiario: number | null = null;
  Importe: number = 0;
  Concepto: string = "";



}
