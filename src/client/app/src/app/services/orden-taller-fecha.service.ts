import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { OrdenTallerFecha } from '../models/ordenTallerFecha';

@Injectable({
  providedIn: 'root'
})
export class OrdenTallerFechaService {

  private ordenesTallerFechaUrl = 'rest/ordenesTallerFecha';  // URL to web api

  ordenTallerFecha: OrdenTallerFecha;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private ordenTallerFechaService: OrdenTallerFechaService) { }

  getByPedido(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.ordenesTallerFechaUrl}/findByPedido/${id}`);
  }
}