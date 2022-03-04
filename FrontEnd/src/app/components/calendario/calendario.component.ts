import { Component, OnInit } from '@angular/core';
import { Disponibilidad } from '../../models/disponibilidad-model';
import { Dia } from '../../models/dia-model';
import { DisponibilidadDeUsuario as Maestro } from '../../models/disponibilidadDeUsuario-model';
import { ActivatedRoute, Router } from '@angular/router';
import { MaestrosService } from 'src/app/services/maestros.service';
import { NotificationService } from 'src/app/notification.service'

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.scss']
})
export class CalendarioComponent implements OnInit {

  constructor(
    private readonly _router: Router,
    private readonly _maestrosService: MaestrosService,
    private readonly _notification: NotificationService,
    private readonly _ac: ActivatedRoute
  ) {}

  dias: Dia [] = [
    {dia: "Horas"},
    {dia: "Lunes"},
    {dia: "Martes"},
    {dia: "Miercoles"},
    {dia: "Jueves"},
    {dia: "Viernes"},
  ]
  

  disponibilidades: Disponibilidad [] = [
    {id: 1 ,hora: "07:00 - 08:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 2 ,hora: "08:00 - 09:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 3 ,hora: "09:00 - 10:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 4 ,hora: "10:00 - 11:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 5 ,hora: "11:00 - 12:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 6 ,hora: "12:00 - 13:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 7 ,hora: "13:00 - 14:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 8 ,hora: "14:00 - 15:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 9 ,hora: "15:00 - 16:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 10 ,hora: "16:00 - 17:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 11 ,hora: "17:00 - 18:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 12 ,hora: "18:00 - 19:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 13 ,hora: "19:00 - 20:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
    {id: 14 ,hora: "20:00 - 21:00", disponibilidad:[{datos:[[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}],[{css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}, {css:"disponibilidadNormal", dato:"0"}]]}]},
  ]
 cont = 0

 casillaSeleccionada = -1;
 
  onClick(disponibilidad: Disponibilidad, fila: number, dia: number){
    
    if(disponibilidad.disponibilidad[0].datos[fila][dia].dato === "1"){
       disponibilidad.disponibilidad[0].datos[fila][dia].dato = "0";
       disponibilidad.disponibilidad[0].datos[fila][dia].css = "disponibilidadNormal"
    }else{ 
      disponibilidad.disponibilidad[0].datos[fila][dia].dato = "1";
      disponibilidad.disponibilidad[0].datos[fila][dia].css = "disponibilidadVerde"
    }
  }

  onSelect(disponibilidad: Disponibilidad, fila: number, dia: number){
    this.onClick(disponibilidad, fila, dia)
    console.log("selecciono")
    console.log("disponibilidad: "+disponibilidad)
    console.log("fila: "+fila)
    console.log("dia: "+dia)
  }

  onUnselect(disponibilidad: Disponibilidad, fila: number, dia: number){
    console.log("deseleccion")
    console.log("disponibilidad: "+disponibilidad)
    console.log("fila: "+fila)
    console.log("dia: "+dia)
  }

  maestro: Maestro={
    id:'',
    nombres:"",
    apellidos:"",
    disponibilidad:""
  }

  esEdit = false;

  async buscarMaestro(){
    this._maestrosService.getMaestroPorId(String(this.maestro.id)).subscribe((res) => {
      if(res != null){
        this.maestro = res
        this.asignarDisponibilidadPorCodigo(this.maestro.disponibilidad);
      }else{
        this.maestro.nombres = "";
        this.maestro.apellidos = "";
        this.asignarDisponibilidadPorCodigo(this._maestrosService.disponibilidadDefault);
      }
    }, error => console.error("Error al encontrar el usuario"))
  }
  
  async buscarMaestroID(id: String){
    this._maestrosService.getMaestroPorId(String(id)).subscribe((res) => {
      if(res != null){
        this.maestro = res
        this.asignarDisponibilidadPorCodigo(this.maestro.disponibilidad);
      }else{
        this.maestro.nombres = "";
        this.maestro.apellidos = "";
        this.asignarDisponibilidadPorCodigo(this._maestrosService.disponibilidadDefault);
      }
    }, error => console.error("Error al encontrar el usuario"))
  }

  async enviarDisponibilidad (){
    this.maestro.disponibilidad = this.generarCodigoDisponibilidad();
    this._maestrosService.addMaestro(this.maestro).subscribe(res =>{
      this._notification.showSuccess("El maestro se agrego correctamente!","EXITO");
    }, error => this._notification.showError("No se pudo agregar","ERROR"))
  }

  asignarDisponibilidadPorCodigo(disponibilidad:String){
    let cont = 0;
    this.disponibilidades.forEach(element => {
      for(let cont1 in [0,1]){
        for(let cont2 in [0,1,2,3,4]){
          if(disponibilidad.charAt(cont) === "1"){element.disponibilidad[0].datos[cont1][cont2].css = "disponibilidadVerde";}
          else{element.disponibilidad[0].datos[cont1][cont2].css = "disponibilidadNormal"}
          element.disponibilidad[0].datos[cont1][cont2].dato = disponibilidad.charAt(cont);
          cont++;
        }
      }
     });
  }

  generarCodigoDisponibilidad(){
    let disponibilidadCode = "";
    this.disponibilidades.forEach(element => {
      for(let cont1 in [0,1]){
        for(let cont2 in [0,1,2,3,4]){
          disponibilidadCode = disponibilidadCode+element.disponibilidad[0].datos[cont1][cont2].dato;
        }
      }
     });
     return disponibilidadCode
  }

  verListadoMaestros(){
    this._router.navigateByUrl("/index/maestros")
  }

  ngOnInit(): void {
    this._ac.paramMap.subscribe(params => {
      const id = params.get('id');
      if(id != null){ this.buscarMaestroID(id)}
    })
  }

}
