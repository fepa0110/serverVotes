import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'
import { DataPackage } from '../models/data-package';
//import { map } from "rxjs/operators";

import { Taller } from '../models/taller';

@Injectable({
  providedIn: 'root'
})
export class TallerService {

  private talleresUrl = 'rest/talleres';  // URL to web api

  taller: Taller;

  constructor(private http: HttpClient,
    private route: ActivatedRoute,
    private tallerService: TallerService) { }

  all(): Observable<DataPackage> {
    return this.http.get<DataPackage>(this.talleresUrl);
  }

  get(id: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.talleresUrl}/${id}`);
  }
  
  save(taller: Taller): Observable<DataPackage> {
    return this.http[taller.id ? 'put' : 'post']<DataPackage>(this.talleresUrl, taller);
  }

  remove(id: number): Observable<DataPackage> {
    return this.http['delete']<DataPackage>(`${this.talleresUrl}/${id}`);
  }

  byPage(page: number, cant: number): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.talleresUrl}?page=${page}&cant=${cant}`);
  }

/*   searchTypes(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.talleresUrl}/types/${text}`);
  } */

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.talleresUrl}/search/${text}`);
  }
}