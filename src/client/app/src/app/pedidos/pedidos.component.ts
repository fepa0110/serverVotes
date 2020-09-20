import { Component, OnInit } from '@angular/core';

import {  NgbModal } from "@ng-bootstrap/ng-bootstrap";

import {
  catchError,
  debounceTime,
  distinctUntilChanged,
  tap,
  switchMap,
  map
} from 'rxjs/operators';

import { NgbdModalConfirm } from "../modal-component";

import { PedidoService } from '../services/pedido.service';
import { PlanificadorService } from "../services/planificador.service";
import { ResultsPage } from "../results-page";
import { PedidoFabricacion } from '../models/pedidoFabricacion';
import { OrdenTrabajo } from '../models/ordenTrabajo';
import { DataPackage } from '../models/data-package';
import { PedidosDetailComponent } from '../pedidos-detail/pedidos-detail.component';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.css']
})
export class PedidosComponent implements OnInit {

  resultsPage: ResultsPage = <ResultsPage>{};
  pages: number[];
  pagesSize : number;
  currentPage: number = 1;
  page: number = 1;
  nextPage: number;
  pedido: PedidoFabricacion;
  estado: string;
  mensajePlanificacion: string;
  ordenesPlanificadas: OrdenTrabajo[];

  searching: boolean = false;
  searchFailed: boolean = false;
  searchingEstado: boolean = false;
  
  fechaEntregaRepanificada: Date;

  constructor(
    private pedidoService: PedidoService,
    private planificadorService: PlanificadorService,
    private _modalService: NgbModal,
  ) { }

  ngOnInit() {
    this.getPedidos();
  }

  getPedidos(): void {
    this.pedidoService.byPage(this.currentPage, 10).subscribe((dataPackage) => {
      this.resultsPage = <ResultsPage>dataPackage.data;
      this.pages = Array.from(Array(this.resultsPage.last).keys());
      this.pagesSize = this.resultsPage.count;
      this.nextPage = this.resultsPage.next;
    });
  }

  getPedidosByEstadoPage(): void {
    this.currentPage = 1; //Reseteo a la primer pagina de la lista
    this.searchingEstado = true;
    this.pedidoService.getByEstadoPage(this.currentPage, 10, this.estado).subscribe((dataPackage) => {
      this.resultsPage = <ResultsPage>dataPackage.data;
      this.pages = Array.from(Array(this.resultsPage.last).keys());
      this.pagesSize = this.resultsPage.count;
      this.nextPage = this.resultsPage.next;
    });
  }

  getPedido(id: string): void {
    this.pedidoService.get(id).subscribe((dataPackage) => {
      this.pedido = <PedidoFabricacion>dataPackage.data; 
    });
  }

  planificarPedido(id: string): void {
    this.planificadorService.planificarPedido(id)
      .subscribe(dataPackage => {
        this.mensajePlanificacion = (<{ mensaje: string }>(<DataPackage>dataPackage).data).mensaje;
        this.modalMensajePlanificiacion(this.mensajePlanificacion, id);
        //this.getPedidos();
      });
  }

  planificarTodosPedidos(): void {
    this.planificadorService.planificarTodosPedidos()
      .subscribe(dataPackage => {
        this.mensajePlanificacion = (<{ mensaje: string }>(<DataPackage>dataPackage).data).mensaje;
        //this.modalMensajePlanificiacion(this.mensajePlanificacion, id);
        //this.getPedidos();
      });
  }

  replanificarPedido(id: string): void{
      this.planificadorService.replanificarPedido(id).subscribe((dataPackage) => {
        let mensajeReplanificacion = (<{ mensaje: string }>(<DataPackage>dataPackage).data).mensaje;
        this.modalReplanificacion(mensajeReplanificacion, id);
      });
    }

  modalReplanificacion(mensaje: string, id: string) {
    const modal = this._modalService.open(NgbdModalConfirm);
    const that = this;
    modal.result.then(
      function () {
        that.getPedidos();
      },
      function () { }
    );
    modal.componentInstance.title = "Replanificacion del pedido N° " + id;
    modal.componentInstance.message = mensaje;
  }

  modalMensajePlanificiacion(mensaje: string, id: string){
    const modal = this._modalService.open(NgbdModalConfirm);
    const that = this;
    modal.result.then(
      function () {
        that.getPedidos();
      },
      function () { }
    );
    modal.componentInstance.title = "Planificacion pedido N° "+id;
    modal.componentInstance.message = mensaje;
  }

  remove(id: string): void {
    const modal = this._modalService.open(NgbdModalConfirm);
    const that = this;
    modal.result.then(
      function () {
        that.pedidoService.remove(id).subscribe((dataPackage) => that.getPedidos());
      },
      function () { }
    );
    modal.componentInstance.title = "Eliminar obra";
    modal.componentInstance.message = "¿Esta seguro de eliminar la obra?";
    modal.componentInstance.description =
      "Si elimina la obra no la podrá utilizar luego.";
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
    if(value){
      this.estado = value;
    }
    return value;
  }

  inputFormat(value: any) {
    if (value) return value;
    return null;
  }

  resetSearchPedidos(){
    this.currentPage = 1; //Reseteo a la primer pagina de la lista
    this.searchingEstado = false;
    this.getPedidos();
  }

  showPage(pageId: number): void {
    if (!this.currentPage) {
      this.currentPage = 1;
    }
    let page = pageId;
    if (pageId == -2) { // First
      page = 1;
    }
    if (pageId == -1) { // Previous
      page = this.currentPage > 1 ? this.currentPage - 1 : this.currentPage;
    }
    if (pageId == -3) { // Next
      page = this.currentPage < this.resultsPage.last ? this.currentPage + 1 : this.currentPage;
    }
    if (pageId == -4) { // Last
      page = this.resultsPage.last;
    }
    if (pageId > 1 && this.pages.length >= pageId) { // Number
      page = this.pages[pageId - 1] + 1;
    }
    this.currentPage = page;
    if(this.searchingEstado){
      this.getPedidosByEstadoPage();
    }
    else{
      this.getPedidos();
    }
  };
}