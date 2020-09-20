import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgApexchartsModule } from "ng-apexcharts";
import { NgbdModalConfirm } from './modal-component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { PedidosComponent } from './pedidos/pedidos.component';
import { PedidosDetailComponent } from './pedidos-detail/pedidos-detail.component';

import { TipoEquiposComponent } from './tipo-equipos/tipo-equipos.component';
import { TipoEquiposDetailComponent } from './tipo-equipos-detail/tipo-equipos-detail.component';

import { TalleresComponent } from './talleres/talleres.component';
import { TalleresDetailComponent } from './talleres-detail/talleres-detail.component';

import { TypeaheadComponent } from './typeahead/typeahead.component';

import { PlanificacionesComponent } from './planificaciones/planificaciones.component';
import { PlanificacionesDetailComponent } from './planificaciones-detail/planificaciones-detail.component';

import { TimelineChartsComponent } from './timeline-charts/timeline-charts.component';
import { TimelineTallerComponent } from './timeline-taller/timeline-taller.component';
import { TimelinePedidosComponent } from "./timeline-pedidos/timeline-pedidos.component";

import { ClientesComponent } from './clientes/clientes.component';
import { ClientesDetailComponent } from './clientes-detail/clientes-detail.component';

import { ProductosComponent } from './productos/productos.component';
import { ProductosDetailComponent } from './productos-detail/productos-detail.component';
import { LoadingComponent } from './loading/loading.component';
import { TimelineOrdenTallerFechaComponent } from './timeline-orden-taller-fecha/timeline-orden-taller-fecha.component';
import { ReplanificacionPedidoComponent } from './replanificacion-pedido/replanificacion-pedido.component';

@NgModule({
  declarations: [ 
    AppComponent,
    HomeComponent,
    PedidosComponent,
    PedidosDetailComponent,
    NgbdModalConfirm,
    TipoEquiposComponent,
    TipoEquiposDetailComponent,
    TalleresComponent,
    TalleresDetailComponent,
    TypeaheadComponent,
    PlanificacionesComponent,
    PlanificacionesDetailComponent,
    TimelineChartsComponent,
    TimelineTallerComponent,
    TimelinePedidosComponent,
    ClientesComponent,
    ClientesDetailComponent,
    ProductosComponent,
    ProductosDetailComponent,
    LoadingComponent,
    TimelineOrdenTallerFechaComponent,
    ReplanificacionPedidoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    NgApexchartsModule
  ],
  entryComponents: [
    NgbdModalConfirm
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
