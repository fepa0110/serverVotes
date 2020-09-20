import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

//import { APIurl } from "../api";
import { DataPackage } from '../models/data-package';


@Injectable({
  providedIn: 'root'
})
export class TypeaheadSearchService {
  APIurl = "http://fpafumi_server_1:8080/labprog-server/rest/";

  constructor(
    private http: HttpClient,
  ) { }

  search(location: string, term: string): Observable<DataPackage> {
    return (term) ?
      this.http.get<DataPackage>(`${this.APIurl}${location}/${encodeURI(term)}`) :
      of(null);
  }
}
