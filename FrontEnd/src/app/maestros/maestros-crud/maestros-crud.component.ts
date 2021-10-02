import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DisponibilidadDeUsuario } from 'src/app/models/disponibilidadDeUsuario-model';
import { MaestrosService } from '../service/maestros.service';
import { NotificationService } from '../../notification.service'

@Component({
  selector: 'app-maestros-crud',
  templateUrl: './maestros-crud.component.html',
  styleUrls: ['./maestros-crud.component.scss']
})
export class MaestrosCrudComponent implements OnInit {

  maestros: DisponibilidadDeUsuario [] = [];
  busqueda: string = "";
  disponibilidad: boolean = false;

  constructor(
    private readonly _maestrosService: MaestrosService,
    private readonly _router: Router,
    private readonly _notification: NotificationService
  ) { }

  buscarMaestro(nombre: string) {
    if (this.busqueda === "") {
      this._notification.showSuccess("Lista obtenida","EXITO");
      this.listaMaestros();
    } else {
      this._maestrosService.getMaestroPorNombre(nombre).subscribe((res) => {
        this.maestros = [];
        if (res === null) {
          this._notification.showError("No se encontro maestro con ese nombre","ERROR");
        } else {
          this._notification.showSuccess("Maestro encontrado","EXITO");
          this.maestros.push(res);
        }
      })
    }
  }

  listaMaestros(){
    return this._maestrosService.getMaestros().subscribe((res) => {
      this.maestros = res;
    })
  }

  atras(){
    this._router.navigateByUrl("/index/calendarizador")
  }

  borrarDisponibilidad(){
    this._notification.showError("Funcionalidad no implementada","ERROR");
  }

  verDisponibilidad(){
    this._notification.showError("Funcionalidad no implementada","ERROR");
  }

  validarDisponibilidad(maestro: DisponibilidadDeUsuario){
    if(maestro.disponibilidad === "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"){
      this.disponibilidad = false;
    }else{
      this.disponibilidad = true;
    }
  }

  ngOnInit(): void {
    this.listaMaestros();
  }

}
