import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { Planificacion } from '../models/planificacion';
import { PlanificacionByFecha } from "../models/planificacionByFecha";

@Injectable({
  providedIn: 'root'
})
export class PlanificacionService {

  private planificacionesUrl = 'rest/planificaciones';  // URL to web api

  planificacion: Planificacion;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private planificacionService: PlanificacionService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.planificacionesUrl);
  }

  allPlanificaciones(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.planificacionesUrl+"/all");
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.planificacionesUrl}/${id}`);
  }

  getByPedido(pedidoId: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.planificacionesUrl}/pedido/${pedidoId}`);
  }

  getByTaller(tallerId: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.planificacionesUrl}/taller/${tallerId}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.planificacionesUrl}?page=${page}&cant=${cant}`);
  }
}