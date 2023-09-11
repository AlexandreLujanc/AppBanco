import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TablaTransferenciasComponent } from './tabla-transferencias/tabla-transferencias.component';
import { RouterModule } from '@angular/router';




@NgModule({
  declarations: [
    TablaTransferenciasComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
    exports: [
      TablaTransferenciasComponent
  ]
})
export class ComponentesModule { }
