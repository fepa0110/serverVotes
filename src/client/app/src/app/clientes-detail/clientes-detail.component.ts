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

import { Cliente } from '../models/cliente';
import { ClienteService } from '../services/cliente.service';

@Component({
  selector: 'app-clientes-detail',
  templateUrl: './clientes-detail.component.html',
  styleUrls: ['./clientes-detail.component.css']
})
export class ClientesDetailComponent implements OnInit {

  cliente: Cliente;
  searching: boolean = false;
  searchFailed: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private location: Location
  ) { }

  ngOnInit() {
    this.get();
  }

  get(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id === 'new') {
      this.cliente = <Cliente>{
        id: null,
        nombre: null,
        cuit: null,
        mail: null
      };
    } else {
      this.clienteService.get(id)
        .subscribe(dataPackage => this.cliente = <Cliente>dataPackage.data);
    }
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.clienteService.save(this.cliente)
      .subscribe(dataPackage => { this.cliente = <Cliente>dataPackage.data; this.goBack(); });
  }
}