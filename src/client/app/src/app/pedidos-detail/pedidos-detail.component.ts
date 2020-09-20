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

import {
  NgbDateStruct,
  NgbCalendar,
  NgbDate,
} from "@ng-bootstrap/ng-bootstrap";

import { PedidoFabricacion } from '../models/pedidoFabricacion';
import { PedidoService } from '../services/pedido.service';
import { ClienteService } from "../services/cliente.service";
import { ProductoService } from "../services/producto.service";

import { ResultsPage } from "../results-page";
import { ModalService } from "../modal.service";

@Component({
  selector: 'app-pedidos-detail',
  templateUrl: './pedidos-detail.component.html',
  styleUrls: ['./pedidos-detail.component.css']
})
export class PedidosDetailComponent implements OnInit {

  pedido: PedidoFabricacion;
  fechaPedidoDate: NgbDateStruct;
  fechaEntregaDate: NgbDateStruct;

  clientesResultsPage: ResultsPage = <ResultsPage>{};
  clientesPages: number[];
  clientesCurrentPage: number = 1;

  view : boolean = false;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private pedidoService: PedidoService,
    private clienteService: ClienteService,
    private productoService: ProductoService,
    private location: Location,
    private calendar: NgbCalendar,
    private modalService: ModalService
  ) { }

  ngOnInit() {
    this.get();
    this.getClientes();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id === "new") {
      this.pedido = {
        id: null,
        cantidad: 0,
        cliente: null,
        estado: null,
        fechaEntrega: new Date(),
        fechaPedido: new Date(),
        producto: null,
        ordenTrabajos: null
      };
      this.fechaPedidoDate = this.calendar.getToday();
      this.fechaEntregaDate = this.calendar.getToday();
    }
    else {
      this.pedidoService.get(id).subscribe((dataPackage) => {
        this.pedido = <PedidoFabricacion>dataPackage.data;
        this.pedido.fechaPedido  = new Date(this.pedido.fechaPedido);
        this.pedido.fechaEntrega = new Date(this.pedido.fechaEntrega);
        this.fechaPedidoDate = NgbDate.from({
          day: this.pedido.fechaPedido.getUTCDate(),
          month: this.pedido.fechaPedido.getUTCMonth(),
          year: this.pedido.fechaPedido.getUTCFullYear(),
        });
        this.fechaEntregaDate = NgbDate.from({
          day: this.pedido.fechaEntrega.getUTCDate(),
          month: this.pedido.fechaEntrega.getUTCMonth() + 1,
          year: this.pedido.fechaEntrega.getUTCFullYear(),
        });
      });
    }
    /* if (id === 'new') {
      this.pedido = <PedidoFabricacion>{};
    } else {
      this.pedidoService.get(id)
        .subscribe(dataPackage => this.pedido = <PedidoFabricacion>dataPackage.data);
    } */
    /* this.pedidoService.get(id)
      .subscribe(dataPackage => this.pedido = <PedidoFabricacion>dataPackage.data); */
  }

  getClientes(): void {
    this.clienteService.byPage(this.clientesCurrentPage, 10).subscribe((dataPackage) => {
      this.clientesResultsPage = <ResultsPage>dataPackage.data;
      this.clientesPages = Array.from(Array(this.clientesResultsPage.last).keys());
    });
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.pedido.fechaPedido = new Date(
      this.fechaPedidoDate.year,
      this.fechaPedidoDate.month - 1,
      this.fechaPedidoDate.day
    );
    this.pedido.fechaEntrega = new Date(
      this.fechaEntregaDate.year,
      this.fechaEntregaDate.month - 1,
      this.fechaEntregaDate.day
    );
    this.pedidoService.save(this.pedido)
      .subscribe(dataPackage => { 
          this.pedido = <PedidoFabricacion>dataPackage.data; 
          this.goBack(); 
    });
  }

  searchType = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => this.searching = true),
      switchMap(term =>
        this.pedidoService.searchTypes(term)
          .pipe(
            map(response => response.data)
          )
          .pipe(
            tap(() => this.searchFailed = false),
            catchError(() => {
              this.searchFailed = true;
              return of([]);
            }))
      ),
      tap(() => this.searching = false)
    )
  
  resultFormat(value: any) {
    return value.nombre;
  }

  inputFormat(value: any) {
    if (value) return value.nombre;
    return null;
  }

  searchCliente = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this.searching = true)),
      switchMap((term) =>
        this.clienteService
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

  searchProducto = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      tap(() => (this.searching = true)),
      switchMap((term) =>
        this.productoService
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
}