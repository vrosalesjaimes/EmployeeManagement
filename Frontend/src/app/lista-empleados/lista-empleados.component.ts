import  Swal  from 'sweetalert2';
import { Component } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoService } from '../empleado.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css']
})
export class ListaEmpleadosComponent {
  empleados:Empleado[];

  constructor(private empleadoServicio:EmpleadoService, private router:Router){

  }

  ngOnInit(): void{
    this.obtenerEmpleados();
  }

  actualizarEmpleado(id:number){
    this.router.navigate(['actualizar-empleado', id]);
  }

  private obtenerEmpleados(){
    this.empleadoServicio.obtenerListaEmpleados().subscribe(
      dato => {
        this.empleados = dato;
      }
    );
  }

  eliminarEmpleado(id:number){
    Swal.fire({
      title: '¿Estás seguro?',
      text: 'Confirma si deseas eliminar al empleado',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sí, elimínalo',
      cancelButtonText: 'No, cancelar',
    }).then((result) => {
      if(result.value){
        this.empleadoServicio.eliminarEmpleado(id).subscribe(dato => {
          console.log(dato);
          this.obtenerEmpleados();
          Swal.fire(
            'Empleado eliminado',
            'El empleado ha sido eliminado con exito',
            'success'
          )
        })
      }
    })
  }

  verDetallesDelEmpleado(id:number){
    this.router.navigate(['empleado-detalles', id]);
  }

}
