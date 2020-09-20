import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {
  catchError,
  debounceTime,
  distinctUntilChanged,
  tap,
  switchMap,
  map,
} from "rxjs/operators";
import { Observable, of } from "rxjs";
import { TypeaheadSearchService } from '../services/typeahead-search.service';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-typeahead',
  templateUrl: './typeahead.component.html',
  styleUrls: ['./typeahead.component.css']
})
export class TypeaheadComponent implements OnInit {

  @Input() nombre: string;
  @Input() location: string;
  @Input() label: string;
  @Input() placeholder: string;
  @Input('format') format: (value: any) => string;

  @Input() data: any;
  @Output() dataChange = new EventEmitter<any>();

  _searching: boolean = false;
  _searchFailed: boolean = false;

  constructor(
    private service: TypeaheadSearchService,
  ) { }

  ngOnInit(): void {
    if (!this.nombre) error("Debe especificar el atributo nombre en Typeahead");
    if (!this.location) this.location = `${this.nombre}s/search`;
    if (!this.label) this.label = this.nombre.charAt(0).toUpperCase() + this.nombre.substring(1).toLowerCase() + ':';
  }

  change(newValue: any) {
    this.data = newValue;
    this.dataChange.emit(newValue);
  }

  // Typeahead 
  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this._searching = true)),
      switchMap((term) =>
        this.service
          .search(this.location, term)
          .pipe(map((response) => response.data))
          .pipe(
            tap(() => (this._searchFailed = false)),
            catchError(() => {
              this._searchFailed = true;
              return of([]);
            })
          )
      ),
      tap(() => (this._searching = false))
    );

  resultFormat = (value: any): string => {
    return this.format(value);
  }

  inputFormat = (value: any): string => {
    if (value) {
      this.change(value);
      return this.resultFormat(value);
    }
    return null;
  }

}
