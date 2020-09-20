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

import { Producto } from '../models/producto';
import { Tarea } from '../models/tarea';

import { ProductoService } from '../services/producto.service';
import { TipoEquipoService } from "../services/tipo-equipo.service";
import { ModalService } from "../modal.service";

@Component({
  selector: 'app-productos-detail',
  templateUrl: './productos-detail.component.html',
  styleUrls: ['./productos-detail.component.css']
})
export class ProductosDetailComponent implements OnInit {

  producto: Producto;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private productoService: ProductoService,
    private location: Location,
    private modalService: ModalService,
    private tipoEquipoService: TipoEquipoService
  ) { }

  ngOnInit() {
    this.get();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id === 'new') {
      this.producto = {
        id: null,
        nombre: null,
        tareas: <Tarea[]>[]
      };
    } else {
      this.productoService.get(id)
        .subscribe(dataPackage => this.producto = <Producto>dataPackage.data);
    }
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.productoService.save(this.producto)
      .subscribe(dataPackage => { 
        this.producto = <Producto>dataPackage.data; 
        this.goBack(); 
      });
  }

  addTarea(): void {
    this.producto.tareas.push({ id: null, nombre: null, orden: null, tiempo: null, tipoEquipo: null});
  }

  removeTarea(tarea: Tarea): void {
    this.modalService
      .confirm(
        "Eliminar tarea",
        "¿Está seguro de borrar esta tarea?",
        "El cambio no se confirmará hasta que no guarde el producto."
      )
      .then(
        (_) => {
          let tareas = this.producto.tareas;
          tareas.splice(tareas.indexOf(tarea), 1);
        },
        (_) => { }
      );
  }

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
}