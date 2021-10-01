import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DisponibilidadDeUsuario } from 'src/app/models/disponibilidadDeUsuario-model';
import { MaestrosService } from '../service/maestros.service';

@Component({
  selector: 'app-maestros-crud',
  templateUrl: './maestros-crud.component.html',
  styleUrls: ['./maestros-crud.component.scss']
})
export class MaestrosCrudComponent implements OnInit {

  maestros: DisponibilidadDeUsuario [] = [];

  constructor(
    private readonly _maestrosService: MaestrosService,
    private readonly _router: Router,
  ) { }

  listaMaestros(){
    return this._maestrosService.getMaestros().subscribe((res) => {
      this.maestros = res;
      console.log(this.maestros);
    })
  }

  atras(){
    this._router.navigateByUrl("/index/calendarizador")
  }

  ngOnInit(): void {
    this.listaMaestros();
  }

}
