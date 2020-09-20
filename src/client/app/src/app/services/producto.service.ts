import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private productosUrl = 'rest/productos';  // URL to web api

  producto: Producto;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private productoService: ProductoService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.productosUrl);
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.productosUrl}/${id}`);
  }

  save(producto: Producto): Observable<DataPackage> {
    return this.http[producto.id ? 'put' : 'post']<DataPackage>(this.productosUrl, producto);
  }

  remove(id: number): Observable<DataPackage> {
    return this.http['delete']<DataPackage>(`${this.productosUrl}/${id}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.productosUrl}?page=${page}&cant=${cant}`);
  }

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.productosUrl}/search/${text}`);
  }
}