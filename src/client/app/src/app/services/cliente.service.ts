import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private clientesUrl = 'rest/clientes';  // URL to web api

  cliente: Cliente;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private clienteService: ClienteService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.clientesUrl);
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.clientesUrl}/${id}`);
  }

  save(cliente: Cliente): Observable<DataPackage> {
    return this.http[cliente.id ? 'put' : 'post']<DataPackage>(this.clientesUrl, cliente);
  }

  remove(id: number): Observable<DataPackage> {
    return this.http['delete']<DataPackage>(`${this.clientesUrl}/${id}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.clientesUrl}/AllByResultsPage?page=${page}&cant=${cant}`);
  }

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.clientesUrl}/search/${text}`);
  }
}