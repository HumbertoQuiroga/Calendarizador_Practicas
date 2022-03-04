import { Inject, Injectable, OnInit } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { Observable } from 'rxjs';
import { DisponibilidadDeUsuario as Maestro } from '../models/disponibilidadDeUsuario-model';

@Injectable({
  providedIn: 'root'
})
export class MaestrosService {

  private readonly _url: string = 'http://localhost:8080/maestro';
  public readonly disponibilidadDefault = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

  constructor(
    private _httpClient: HttpClient,
  ) { }

  getMaestros(): Observable<any> {
    return this._httpClient.get<any>(this._url);
  }

  getMaestroPorNombre(nombre: string): Observable<any> {
    return this._httpClient.get<any>(`${this._url}/nombres/${nombre}`);
  }

  getMaestroPorId(id: string): Observable<any> {
    return this._httpClient.get<any>(`${this._url}/id/${id}`);
  }

  addMaestro(maestro:Maestro): Observable<any>{
    return this._httpClient.post(this._url, maestro);
  }

  updateMaestro(maestro: Maestro): Observable<any>{
    return this._httpClient.put(`${this._url}/maestros`,maestro);
  }
}


