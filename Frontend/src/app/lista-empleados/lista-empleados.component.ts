import { Component } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css']
})
export class ListaEmpleadosComponent {
  empleados:Empleado[];

  constructor(private empleadoServicio:EmpleadoService){

  }

  ngOnInit(): void{
    this.obtenerEmpleados();
  }

  private obtenerEmpleados(){
    this.empleadoServicio.obtenerListaEmpleados().subscribe(
      dato => {
        this.empleados = dato;
      }
    );
  }

}
