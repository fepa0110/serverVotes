import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Observable, of } from 'rxjs';
import {
  catchError,
  debounceTime,
  distinctUntilChanged,
  tap,
  switchMap,
  map
} from 'rxjs/operators';

import { TipoEquipo } from '../models/tipoEquipo';
import { TipoEquipoService } from '../services/tipo-equipo.service';

@Component({
  selector: 'app-tipo-equipos-detail',
  templateUrl: './tipo-equipos-detail.component.html',
  styleUrls: ['./tipo-equipos-detail.component.css']
})
export class TipoEquiposDetailComponent implements OnInit {

  tipoEquipo: TipoEquipo;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private tipoEquipoService: TipoEquipoService,
    private location: Location
  ) { }

  ngOnInit() {
    this.get();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id === 'new') {
      this.tipoEquipo = <TipoEquipo>{};
    } else {
      this.tipoEquipoService.get(id)
        .subscribe(dataPackage => this.tipoEquipo = <TipoEquipo>dataPackage.data);
    }
    /* this.tipoEquipoService.get(id)
      .subscribe(dataPackage => this.tipoEquipo = <TipoEquipo>dataPackage.data); */
  }

  goBack(): void {
    this.location.back();
  }

  save(): void { 
    this.tipoEquipoService.save(this.tipoEquipo)
      .subscribe(dataPackage => { this.tipoEquipo = <TipoEquipo>dataPackage.data; this.goBack(); });
  }
}