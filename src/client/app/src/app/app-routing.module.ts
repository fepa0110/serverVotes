import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'

import { PedidosComponent } from './pedidos/pedidos.component'
import { PedidosDetailComponent } from "./pedidos-detail/pedidos-detail.component";

import { ReplanificacionPedidoComponent } from "./replanificacion-pedido/replanificacion-pedido.component";

import { TipoEquiposComponent } from './tipo-equipos/tipo-equipos.component';
import { TipoEquiposDetailComponent } from "./tipo-equipos-detail/tipo-equipos-detail.component";

import { TalleresComponent } from './talleres/talleres.component';
import { TalleresDetailComponent } from "./talleres-detail/talleres-detail.component";

import { ClientesComponent } from './clientes/clientes.component';
import { ClientesDetailComponent } from "./clientes-detail/clientes-detail.component";

import { ProductosComponent } from './productos/productos.component';
import { ProductosDetailComponent } from "./productos-detail/productos-detail.component";

import { PlanificacionesComponent } from './planificaciones/planificaciones.component';

import { TimelineChartsComponent } from "./timeline-charts/timeline-charts.component";
import { TimelineTallerComponent } from "./timeline-taller/timeline-taller.component";
import { TimelinePedidosComponent } from "./timeline-pedidos/timeline-pedidos.component";
import { TimelineOrdenTallerFechaComponent } from "./timeline-orden-taller-fecha/timeline-orden-taller-fecha.component";

const routes: Routes = [
  { path: '', component: HomeComponent },

  { path: 'pedidos', component: PedidosComponent },
  { path: 'pedidos/:id', component: PedidosDetailComponent },
  { path: 'pedidos/replanificarPedido/:id', component: ReplanificacionPedidoComponent },

  { path: 'tipoEquipos', component: TipoEquiposComponent },
  { path: 'tipoEquipos/:id', component: TipoEquiposDetailComponent },

  { path: 'talleres', component: TalleresComponent },
  { path: 'talleres/:id', component: TalleresDetailComponent },

  { path: 'clientes', component: ClientesComponent },
  { path: 'clientes/:id', component: ClientesDetailComponent },

  { path: 'productos', component: ProductosComponent },
  { path: 'productos/:id', component: ProductosDetailComponent },

  { path: 'planificaciones', component: PlanificacionesComponent },

  { path: 'timelineCharts', component: TimelineChartsComponent },
  { path: 'timelineTaller/:id', component: TimelineTallerComponent },
  { path: 'timelinePedidos/:id', component: TimelinePedidosComponent },
  { path: 'timelineOrdenTallerFecha/:id', component: TimelineOrdenTallerFechaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
