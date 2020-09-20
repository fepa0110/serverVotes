import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { OrdenTrabajo } from '../models/ordenTrabajo';

@Injectable({
  providedIn: 'root'
})
export class OrdenTrabajoService {

  private ordenesUrl = 'rest/ordenTrabajos';  // URL to web api

  ordenTrabajo: OrdenTrabajo;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private ordenTrabajoService: OrdenTrabajoService) { }

  getByPedido(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.ordenesUrl}/findByPedido/${id}`);
  }
}