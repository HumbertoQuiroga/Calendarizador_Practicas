import { Component, OnInit } from '@angular/core';
import { Disponibilidad } from '../models/disponibilidad-model';
import { Dia } from '../models/dia-model';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.scss']
})
export class CalendarioComponent implements OnInit {

  constructor(
    private readonly _router: Router,
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
    {id: 1 ,hora: "07:00 - 08:00", disponibilidad:"0"},
    {id: 2 ,hora: "08:00 - 09:00", disponibilidad:"0"},
    {id: 3 ,hora: "09:00 - 10:00", disponibilidad:"0"},
    {id: 4 ,hora: "10:00 - 11:00", disponibilidad:"0"},
    {id: 5 ,hora: "11:00 - 12:00", disponibilidad:"0"},
    {id: 6 ,hora: "13:00 - 14:00", disponibilidad:"0"},
    {id: 7 ,hora: "14:00 - 15:00", disponibilidad:"0"},
    {id: 8 ,hora: "15:00 - 16:00", disponibilidad:"0"},
    {id: 9 ,hora: "16:00 - 17:00", disponibilidad:"0"},
    {id: 10 ,hora: "17:00 - 18:00", disponibilidad:"0"},
    {id: 11 ,hora: "18:00 - 19:00", disponibilidad:"0"},
    {id: 12 ,hora: "19:00 - 20:00", disponibilidad:"0"},
  ]

  onClick(disponibilidad: Disponibilidad){
    disponibilidad.disponibilidad = "1";
  }

  crearDisponibilidad(){
    


    // this.disponibilidades.forEach(element => {
    //   console.log(JSON.parse(element.disponibilidad));
    // });
  }

  ngOnInit(): void {

  }

}
