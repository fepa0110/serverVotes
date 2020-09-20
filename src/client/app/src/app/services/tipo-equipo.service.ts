import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { TipoEquipo } from '../models/tipoEquipo';

@Injectable({
  providedIn: 'root'
})
export class TipoEquipoService {

  private tipoEquiposUrl = 'rest/tipoEquipos';  // URL to web api

  tipoEquipo: TipoEquipo;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private tipoEquipoService: TipoEquipoService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.tipoEquiposUrl);
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.tipoEquiposUrl}/${id}`);
  }
  
  save(tipoEquipo: TipoEquipo): Observable<DataPackage> {
    return this.http[tipoEquipo.id ? 'put' : 'post']<DataPackage>(this.tipoEquiposUrl, tipoEquipo);
  }

  remove(id: number): Observable<DataPackage> {
    return this.http['delete']<DataPackage>(`${this.tipoEquiposUrl}/${id}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.tipoEquiposUrl}?page=${page}&cant=${cant}`);
  }

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.tipoEquiposUrl}/search/${text}`);
  }
}