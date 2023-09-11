import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  constructor(private httpClient: HttpClient) { }

  urlApi: string = 'http://localhost:8080/transferencia';

  //Traer todas las transferencias

  obtenerTransferencias() {
    return this.httpClient.get(this.urlApi);
  }

  obtenerTransferenciasEnviadas(idOrdenante: number) {
    return this.httpClient.get(this.urlApi + "/enviadas/" + idOrdenante);
  }

  // Traer las transferencias recibidas por un beneficiario (cliente)
  obtenerTransferenciasRecibidas(idBeneficiario: number) {
    return this.httpClient.get(this.urlApi + "/recibidas/" + idBeneficiario);
  }

  //Guardar una transferencia
crearTransferencia(transferencia: any){
  return this.httpClient.post(this.urlApi, transferencia);
}
  //traer transferencia por id
  obtenerTransferenciaPorId(id: number){
    const url = `${this.urlApi}/${id}`;
return this.httpClient.get(url)
  }

}
