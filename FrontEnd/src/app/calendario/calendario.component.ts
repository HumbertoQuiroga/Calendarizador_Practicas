import { Component, OnInit } from '@angular/core';
import { Disponibilidad } from '../models/disponibilidad-model';
import { Dia } from '../models/dia-model';
import { DisponibilidadDeUsuario as Maestro } from '../models/disponibilidadDeUsuario-model';
import { Router, RouterLink } from '@angular/router';
import axios from 'axios';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.scss']
})
export class CalendarioComponent implements OnInit {

  constructor(
    private readonly _router: Router,
  ) {}

  disponibilidadCode = ""

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
  onClick(disponibilidad: Disponibilidad, columna: number, dia: number){
    
    if(disponibilidad.disponibilidad[0].datos[columna][dia].dato === "1"){
       disponibilidad.disponibilidad[0].datos[columna][dia].dato = "0";
       disponibilidad.disponibilidad[0].datos[columna][dia].css = "disponibilidadNormal"
    }else{ 
      disponibilidad.disponibilidad[0].datos[columna][dia].dato = "1";
      disponibilidad.disponibilidad[0].datos[columna][dia].css = "disponibilidadVerde"
    }
    //console.log("ID: "+disponibilidad.id+ ", columna: "+columna+", dia: "+dia+", Disponibilidad: "+ disponibilidad.disponibilidad[0].datos[columna][0].dato, disponibilidad.disponibilidad[0].datos[columna][1].dato, disponibilidad.disponibilidad[0].datos[columna][2].dato, disponibilidad.disponibilidad[0].datos[columna][3].dato, disponibilidad.disponibilidad[0].datos[columna][4].dato)
  }

  maestro: Maestro={
    id:"",
    nombres:"",
    apellidos:"",
    disponibilidad:""
  }

  esEdit = false;

  async buscarMaestro(){
    let id_Maestro = (document.getElementById("id_maestro") as HTMLInputElement).value;
    const find_maestro = await axios.get('http://localhost:8080/maestro/'+id_Maestro);
    if(find_maestro.status === 200){
      (document.getElementById("nombres_maestro") as HTMLInputElement).value = find_maestro.data.nombres;
      (document.getElementById("apellidos_maestro") as HTMLInputElement).value = find_maestro.data.apellidos;
      this.asignarDisponibilidadPorCodigo(find_maestro.data.disponibilidad);
      this.esEdit = true;
    }else{
      (document.getElementById("nombres_maestro") as HTMLInputElement).value = '';
      (document.getElementById("apellidos_maestro") as HTMLInputElement).value = '';
      this.asignarDisponibilidadPorCodigo("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
      this.esEdit = false;
    }
  }
  

  async enviarDisponibilidad (){
    this.generarCodigoDisponibilidad();
    this.maestro.id =  (document.getElementById("id_maestro") as HTMLInputElement).value;
    this.maestro.nombres = (document.getElementById("nombres_maestro") as HTMLInputElement).value;
    this.maestro.apellidos = (document.getElementById("apellidos_maestro") as HTMLInputElement).value;
    this.maestro.disponibilidad = this.disponibilidadCode;
    
    await axios.post('http://localhost:8080/maestro', this.maestro)
        .then((res)=>{
            if(res){
              if(this.esEdit === true){alert("El maestro fue actualizado correctamente!");}
              else{alert("El maestro fue agregado correctamente!");}
            }
        }).catch((err)=>{
          console.log(err);
        });
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
    this.disponibilidadCode = "";
    this.disponibilidades.forEach(element => {
      for(let cont1 in [0,1]){
        for(let cont2 in [0,1,2,3,4]){
          this.disponibilidadCode = this.disponibilidadCode+element.disponibilidad[0].datos[cont1][cont2].dato;
        }
      }
     });
  }

  verListadoMaestros(){
    this._router.navigateByUrl("/index/maestros")
  }

  ngOnInit(): void {

  }

}
