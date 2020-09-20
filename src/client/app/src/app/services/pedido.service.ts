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
export class PedidoService {

  private pedidosUrl = 'rest/pedidosFabricacion';  // URL to web api

  pedido: PedidoFabricacion;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private pedidoService: PedidoService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.pedidosUrl);
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}/${id}`);
  }

  getByEstado(estado: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}/estado/${estado}`);
  }

  getByEstadoPage(page: number, cant: number, estado: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}/estado/${estado}?page=${page}&cant=${cant}`);
  }
  
  save(pedido: PedidoFabricacion): Observable<DataPackage> {
    return this.http[pedido.id ? 'put' : 'post']<DataPackage>(this.pedidosUrl, pedido);
  }

  remove(id: string): Observable<DataPackage> {
    return this.http['delete']<DataPackage>(`${this.pedidosUrl}/${id}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}?page=${page}&cant=${cant}`);
  }

  searchTypes(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}/types/${text}`);
  }

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.pedidosUrl}/search/${text}`);
  }
}