import { Component, OnInit } from '@angular/core';

import { PlanificacionService } from "../services/planificacion.service";

@Component({
  selector: 'app-planificacion-pedido',
  templateUrl: './planificacion-pedido.component.html',
  styleUrls: ['./planificacion-pedido.component.css']
})
export class PlanificacionPedidoComponent implements OnInit {
  equipos = [
    {
      nombre: "Cortadora",
      planificaciones: [
        { tarea: "1", start: 0, end: 50 },
        { tarea: "2", start: 70, end: 90 },
        { tarea: "3", start: 90, end: 130 },
        { tarea: "4", start: 150, end: 180 },
      ]
    },
    {
      nombre: "Lijadora",
      planificaciones: [
        { tarea: "10", start: 10, end: 80 },
        { tarea: "20", start: 90, end: 150 },
        { tarea: "30", start: 160, end: 190 },
        { tarea: "40", start: 200, end: 230 },
      ]
    },
    {
      nombre: "Plegadora",
      planificaciones: [
        { tarea: "11", start: 30, end: 40 },
        { tarea: "21", start: 70, end: 90 },
        { tarea: "31", start: 130, end: 150 },
        { tarea: "41", start: 180, end: 190 },
        { tarea: "51", start: 190, end: 200 },
        { tarea: "61", start: 220, end: 240 },
      ]
    },
  ]

  planificaciones = [
    {
      nombre: "Cortar patas",
        tarea: [{tiempo: 100 },
          { tiempo: 50 },
          { tiempo: 50 },
          { tiempo: 70 },
          { tiempo: 100 }]
    },
    {
      nombre: "Lijar patas",
      tarea: [{ tiempo: 50 }]
    },
    {
      nombre: "Pegar patas",
      tarea: [{ tiempo: 50 },
              { tiempo: 70 },
              { tiempo: 100 }]
    },
  ]
  // planificacionService : PlanificacionService;

  // planificaciones = this.planificacionService.getByPedido("1");

  constructor() { 
    
  }

  ngOnInit() {
  }

}
