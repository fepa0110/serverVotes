import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';

import { Planificacion } from '../models/planificacion';
import { PlanificacionByFecha } from "../models/planificacionByFecha";

@Injectable({
  providedIn: 'root'
})
export class TimelineChartsService {
  private planificacionesUrl = 'rest/planificacionesFilter';  // URL to web api

  planificacion: Planificacion;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private timeLineChartsService: TimelineChartsService) { }
  
  // + "/byTallerFecha"
  findByTallerFecha(tallerByFecha: {id:number,fechaDesde:Date,fechaHasta:Date}): Observable<DataPackage> {
    return this.http['post']<DataPackage>(this.planificacionesUrl, tallerByFecha);
  }
}
