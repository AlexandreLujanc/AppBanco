import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesRoutingModule } from './pages-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { TransferenciasRecibidasComponent } from './transferencias-recibidas/transferencias-recibidas.component';
import { TransferenciasEnviadasComponent } from './transferencias-enviadas/transferencias-enviadas.component';
import { ComponentesModule } from '../componentes/componentes.module';
import { TransferenciasComponent } from './transferencias/transferencias.component';
import { NuevaTransferenciaComponent } from './nueva-transferencia/nueva-transferencia.component';
import { DetalleTransferenciaComponent } from './detalle-transferencia/detalle-transferencia.component';
import { MiPerfilComponent } from './mi-perfil/mi-perfil.component';


@NgModule({
  declarations: [DashboardComponent, TransferenciasRecibidasComponent, TransferenciasEnviadasComponent, TransferenciasComponent, NuevaTransferenciaComponent, DetalleTransferenciaComponent, MiPerfilComponent],
  imports: [
    CommonModule,
    PagesRoutingModule,
    FormsModule,
    ComponentesModule,
  ]
})
export class PagesModule { }
