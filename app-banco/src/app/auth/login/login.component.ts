import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { SesionService } from 'src/app/services/sesion-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

email: string = "";
password: string = "";

constructor (private clienteService:ClienteService, private router:Router, private sesionService: SesionService){}


validarLogin(){
  console.log(this.email,this.password);

  const usuario = this.clienteService.hacerLogin(this.email,this.password)
  if (usuario!==null){
    console.log(usuario);
    this.router.navigateByUrl("/pages/dashboard"); 
}else{
  console.error("incorrecto");
  this.email = "";
  this.password = "";
}

}

enviarLogin() {
  this.clienteService.login(this.email, this.password).subscribe(
    cliente => {
      console.log({ cliente });
      if (cliente !== null) {
        this.clienteService.crearSesion(cliente);
        this.sesionService.iniciarSesion();
        this.router.navigateByUrl("/pages/dashboard");
      } else {
        // Manejar caso cuando cliente es null
      }
    },
    error => {
      console.error({ error });
    }
  );
  this.email = "";
  this.password = "";
}


}

