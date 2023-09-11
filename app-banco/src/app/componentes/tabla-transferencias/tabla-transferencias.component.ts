import { Component, Input } from '@angular/core';
import { transferenciasEnviadas } from 'src/app/datos/transferencias-ejemplo';
import { transferenciasRecibidas } from 'src/app/datos/transferencias-ejemplo';
@Component({
  selector: 'app-tabla-transferencias',
  templateUrl: './tabla-transferencias.component.html',
  styleUrls: ['./tabla-transferencias.component.css']
})
export class TablaTransferenciasComponent {

@Input() transferencias: any[] = [];

}
