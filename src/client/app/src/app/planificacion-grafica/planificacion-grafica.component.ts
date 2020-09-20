import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-planificacion-grafica',
  templateUrl: './planificacion-grafica.component.html',
  styleUrls: ['./planificacion-grafica.component.css']
})

export class PlanificacionGraficaComponent implements OnInit {

  @Input() planning: { tarea: string, start: number, end: number }[] = [];
  @Input() planificaciones: { tiempo: number }[] = [];

  @Input() escala = 1.5;
  width = 5000;

  constructor() { }

  ngOnInit() {
  }

  getBars() {
    let result = [];
    let t = 0;
    let start = 0;
    let anchoHueco = 0;
    let anchoBar = 0;
    for (let p of this.planificaciones) {

      anchoHueco = (start - t) * this.escala;
      anchoBar = (p.tiempo - start) * this.escala;

      result.push({ width: anchoHueco, hueco: true });
      result.push({ width: anchoBar, hueco: false, label: p.tiempo });

      start = anchoHueco + anchoBar;

      t = anchoHueco - p.tiempo;
    }

    this.width = t * this.escala;

    return result;
  }

/*   getBars() {
    let result = [];
    let t = 0;
    let start = 0;
    let hueco = 0;
    for (let p of this.planificaciones) {

      result.push({ width: t * this.escala, hueco: true });
      result.push({ width: hueco * this.escala, hueco: false, label: p.tiempo });
      hueco = hueco + p.tiempo;

      t = t + p.tiempo;
    }

    this.width = t * this.escala;

    return result;
  } */

  /*getBars() {
    let result = [];
    let t = 0;
    for (let p of this.planning) {

      result.push({ width: (p.start - t) * this.escala, hueco: true });
      result.push({ width: (p.end - p.start) * this.escala, hueco: false, label: p.tarea });

      t = p.end;
    }

    this.width = t * this.escala;

    return result;
  } 
  */

}