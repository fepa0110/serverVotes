import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Location } from "@angular/common";
import { Observable, of } from "rxjs";
import {
  catchError,
  debounceTime,
  distinctUntilChanged,
  tap,
  switchMap,
  map,
} from "rxjs/operators"

import { Taller } from "../models/taller";
import { Equipo } from "../models/equipo"
import { TipoEquipo } from "../models/tipoEquipo";
import { TallerService } from "../services/taller.service";
import { EquipoService } from "../services/equipo.service";
import { TipoEquipoService } from "../services/tipo-equipo.service";
import { ModalService } from "../modal.service";

@Component({
  selector: "app-talleres-detail",
  templateUrl: "./talleres-detail.component.html",
  styleUrls: ["./talleres-detail.component.css"],
})
export class TalleresDetailComponent implements OnInit {
  taller: Taller;
  equipos: Equipo[];
  tipoEquipo: any;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tallerService: TallerService,
    private equipoService: EquipoService,
    private tipoEquipoService: TipoEquipoService,
    private location: Location,
    private modalService: ModalService
  ) { }

  ngOnInit() {
    this.get();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id === "new") {
      this.taller = {
        id: null,
        codigo: null,
        equipos: <Equipo[]>[],
      };
    }
    else {
      this.tallerService.get(id).subscribe((dataPackage) => {
        this.taller = <Taller>dataPackage.data;
      });
    }
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    /*this.tallerService.save(this.taller).subscribe((dataPackage) => {
this.router
        .navigateByUrl("/", {
          skipLocationChange: true,
        })
        .then(() =>
          this.router.navigate(["/talleres/" + (<Taller>dataPackage.data).id])
        );
    }); */
    this.tallerService.save(this.taller)
          .subscribe(dataPackage => { 
            this.taller = <Taller>dataPackage.data; 
            this.goBack(); 
          });
  }

  searchEquipo = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this.searching = true)),
      switchMap((term) =>
        this.equipoService
          .search(term)
          .pipe(map((response) => response.data))
          .pipe(
            tap(() => (this.searchFailed = false)),
            catchError(() => {
              this.searchFailed = true;
              return of([]);
            })
          )
      ),
      tap(() => (this.searching = false))
    );
  
  searchTipoEquipo = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this.searching = true)),
      switchMap((term) =>
        this.tipoEquipoService
          .search(term)
          .pipe(map((response) => response.data))
          .pipe(
            tap(() => (this.searchFailed = false)),
            catchError(() => {
              this.searchFailed = true;
              return of([]);
            })
          )
      ),
      tap(() => (this.searching = false))
    );

  resultFormatTipoEquipo(value: any) {
    return value.nombre;
  }

  inputFormatTipoEquipo(value: any) {
    if (value) return value.nombre;
    return null;
  }

  resultFormat(value: any) {
    return value.name;
  }

  inputFormat(value: any) {
    if (value) return value.name;
    return null;
  }

  searchTaller = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this.searching = true)),
      switchMap((term) =>
        this.tallerService
          .search(term)
          .pipe(map((response) => response.data))
          .pipe(
            tap(() => (this.searchFailed = false)),
            catchError(() => {
              this.searchFailed = true;
              return of([]);
            })
          )
      ),
      tap(() => (this.searching = false))
    );

  addEquipo(): void {
    this.taller.equipos.push(
      { id: null, codigo: null, capacidad: 0, tipoEquipo: null, planificaciones: null});
  }

  removeEquipo(equipo: Equipo): void {
    this.modalService
      .confirm(
        "Eliminar equipo",
        "¿Está seguro de borrar este equipo?",
        "El cambio no se confirmará hasta que no guarde el taller."
      )
      .then(
        (_) => {
          let equipos = this.taller.equipos;
          equipos.splice(equipos.indexOf(equipo), 1);
        },
        (_) => { }
      );
  }
}