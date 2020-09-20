import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { PedidoFabricacion } from '../models/pedidoFabricacion';

@Injectable({
  providedIn: 'root'
})
export class PlanificadorService {
  private planificadorUrl = 'rest/planificador';  // URL to web api

  pedido: PedidoFabricacion;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private planificadorService: PlanificadorService) { }

  planificarPedido(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.planificadorUrl+"/pedido/"+id);
  }

  planificarTodosPedidos(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.planificadorUrl + "/planificarPedidos");
  }

  replanificarPedido(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.planificadorUrl + "/replanificarPedido/" + id);
  }
}
