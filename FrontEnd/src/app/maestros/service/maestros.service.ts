import { Inject, Injectable, OnInit } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaestrosService {

  private readonly _url: string = 'http://localhost:8080/maestro/';

  constructor(
    private _httpClient: HttpClient,
  ) { }

  getMaestros(): Observable<any> {
    return this._httpClient.get<any>(this._url);
  }
}


