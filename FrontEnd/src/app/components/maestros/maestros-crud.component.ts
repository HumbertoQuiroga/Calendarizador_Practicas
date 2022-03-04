import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DisponibilidadDeUsuario } from 'src/app/models/disponibilidadDeUsuario-model';
import { MaestrosService } from 'src/app/services/maestros.service';
import { NotificationService } from 'src/app/notification.service';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogMessageComponent } from '../confirm-dialog-message/confirm-dialog-message.component';

@Component({
  selector: 'app-maestros-crud',
  templateUrl: './maestros-crud.component.html',
  styleUrls: ['./maestros-crud.component.scss']
})
export class MaestrosCrudComponent implements OnInit {

  //Lista con todos los maestros
  maestros: DisponibilidadDeUsuario[] = [];
  //Lista con con los maestros de la busqueda
  listaMaestrosBusqueda: DisponibilidadDeUsuario[] =[];
  //Lista que se muestra por pantalla
  listaMaestros: DisponibilidadDeUsuario[] = [];
  
  busqueda: string = "";
  tipoBusqueda: string ="mostrarTodos";
  disponibilidad: boolean = false;
  dispoDefault:String ="";


  constructor(
    private readonly _maestrosService: MaestrosService,
    private readonly _router: Router,
    private readonly _notification: NotificationService,
    public dialog: MatDialog
  ) { this.dispoDefault = this._maestrosService.disponibilidadDefault}

  openDialog(maestro: DisponibilidadDeUsuario):void{
    const dialogRef = this.dialog.open(ConfirmDialogMessageComponent,{
      width: '550px',
      height: '300px',
      data: maestro.apellidos+' '+maestro.nombres
    });
    dialogRef.afterClosed().subscribe(res =>{
        console.log(res);
        if(res){
          maestro.disponibilidad = this._maestrosService.disponibilidadDefault;
          this._maestrosService.updateMaestro(maestro).subscribe(res =>{
            if(res != null){this._notification.showSuccess("Se borro la disponibilidad","EXITO");}
            else{this._notification.showError("No se pudo borrar la disponibilidad","ERROR");}
          }, error =>{this._notification.showError("No se pudo borrar la disponibilidad","ERROR");});
        }
    })
  }


  buscarMaestro() {
    if(this.busqueda != ""){
      this.busqueda = this.busqueda.toUpperCase();
      this.listaMaestrosBusqueda.splice(0, this.listaMaestrosBusqueda.length);
      if(this.tipoBusqueda === "porID"){
        for (let maestro of this.maestros){
          if(maestro.id?.includes(this.busqueda)){this.listaMaestrosBusqueda.push(maestro);}
          this.listaMaestros = this.listaMaestrosBusqueda;
        }
      }
      else if(this.tipoBusqueda === "porNombre"){
        for (let maestro of this.maestros){
          let nombreCompleto = maestro.apellidos+" "+maestro.nombres;
          if(nombreCompleto?.includes(this.busqueda)){this.listaMaestrosBusqueda.push(maestro);}
          this.listaMaestros = this.listaMaestrosBusqueda;
        }
      }else{this.listaMaestros = this.maestros}
    }
    else{
      if(this.listaMaestros == this.listaMaestrosBusqueda){this.listaMaestros = this.maestros}
    }
  }

  cambiarTipoBusqueda(){
    this.buscarMaestro();
  }

  getlistaMaestros(){
    return this._maestrosService.getMaestros().subscribe((res) => {
      this.maestros = res;
      this.listaMaestros = res;
    })
  }

  atras(){
    this._router.navigateByUrl("/index/calendarizador");
  }

  verDisponibilidad(id: any){
    this._router.navigateByUrl("/index/calendarizador/"+id);
  }


  ngOnInit(): void {
    this.getlistaMaestros();
  }

}
