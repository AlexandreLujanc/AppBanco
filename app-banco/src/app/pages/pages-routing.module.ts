import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TransferenciasRecibidasComponent } from './transferencias-recibidas/transferencias-recibidas.component';
import { TransferenciasEnviadasComponent } from './transferencias-enviadas/transferencias-enviadas.component';
import { TransferenciasComponent } from './transferencias/transferencias.component';
import { NuevaTransferenciaComponent } from './nueva-transferencia/nueva-transferencia.component';
import { DetalleTransferenciaComponent } from './detalle-transferencia/detalle-transferencia.component';
import { MiPerfilComponent } from './mi-perfil/mi-perfil.component';
import { loginGuard } from '../guards/login.guard';


const routes: Routes = [
  {path: "dashboard", component:DashboardComponent},
  {path: "transferencias-recibidas", component:TransferenciasRecibidasComponent, canActivate: [loginGuard]},
  {path: "transferencias-enviadas", component:TransferenciasEnviadasComponent, canActivate: [loginGuard]}, 
  {path: "transferencias", component:TransferenciasComponent},
  {path: "nueva-transferencia", component:NuevaTransferenciaComponent, canActivate: [loginGuard]},
  {path: "detalle-transferencia/:id", component:DetalleTransferenciaComponent, canActivate: [loginGuard]},
  {path: "mi-perfil", component:MiPerfilComponent, canActivate: [loginGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
