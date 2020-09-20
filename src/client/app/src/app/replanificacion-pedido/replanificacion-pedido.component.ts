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
import { PlanificadorService } from '../services/planificador.service';

@Component({
  selector: 'app-replanificacion-pedido',
  templateUrl: './replanificacion-pedido.component.html',
  styleUrls: ['./replanificacion-pedido.component.css']
})
export class ReplanificacionPedidoComponent implements OnInit {

  pedido: PedidoFabricacion;
  pedidoId: String;
  fechaEntregaDate: NgbDateStruct;
  fechaEntregaRepanificada: Date;

  fechaEntregaRecibida : boolean = false;

  view: boolean = false;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private pedidoService: PedidoService,
    private planificadorService: PlanificadorService,
    private clienteService: ClienteService,
    private productoService: ProductoService,
    private location: Location,
    private calendar: NgbCalendar,
    private modalService: ModalService
  ) { }

  ngOnInit() {
    this.get();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.pedidoId = id;
    this.pedidoService.get(id).subscribe((dataPackage) => {
        this.pedido = <PedidoFabricacion>dataPackage.data;
        this.pedido.fechaEntrega = new Date(this.pedido.fechaEntrega);
        this.fechaEntregaDate = NgbDate.from({
          day: this.pedido.fechaEntrega.getUTCDate(),
          month: this.pedido.fechaEntrega.getUTCMonth() + 1,
          year: this.pedido.fechaEntrega.getUTCFullYear(),
        });
      });
    }

/*   getFechaEntregaReplanificada(){
    const id = this.route.snapshot.paramMap.get('id');
    this.planificadorService.obtenerFechaReplanificacion(id).subscribe((dataPackage) => {
      let fechaRecibida = <Date>(<{ fechaEntrega: Date }>dataPackage.data).fechaEntrega;
      this.fechaEntregaRepanificada = new Date(fechaRecibida);
      this.fechaEntregaDate = NgbDate.from({
        day: this.fechaEntregaRepanificada.getUTCDate(),
        month: this.fechaEntregaRepanificada.getUTCMonth() + 1,
        year: this.fechaEntregaRepanificada.getUTCFullYear(),
      });
      this.fechaEntregaRecibida = true;
    });
  } */

  goBack(): void {
    this.location.back();
  }

  save(): void {
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
}