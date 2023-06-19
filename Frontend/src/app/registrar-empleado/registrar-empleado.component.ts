import { Component } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css']
})
export class RegistrarEmpleadoComponent {
  
  empleado:Empleado = new Empleado();
  constructor(private empleadoServicio:EmpleadoService, private router:Router){

  }

  ngOnInit():void{
  }

  guardarEmpleado(){
    this.empleadoServicio.registrarEmpleado(this.empleado).subscribe({
      next: dato => {
        console.log(dato);
        this.irAListaEmpleados();
      },
      error: error => {
        console.log(error);
      }
    });
  }

  irAListaEmpleados(){
    this.router.navigate(['/empleados']);
  }

  onSubmit(){
    this.guardarEmpleado()
  }

}
