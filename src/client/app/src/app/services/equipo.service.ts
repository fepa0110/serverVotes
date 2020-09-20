import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { DataPackage } from '../models/data-package';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private equiposUrl = 'rest/equipos';  // URL to web api

  constructor(private http: HttpClient, ) { }

  search(text: string): Observable<DataPackage> {
    return this.http.get<DataPackage>(`${this.equiposUrl}?search=${text}`);
  }
}