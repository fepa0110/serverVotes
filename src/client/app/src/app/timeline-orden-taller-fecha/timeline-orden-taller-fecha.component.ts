import { Component, Directive, Input, ViewChild } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Planificacion } from '../models/planificacion';

import { PlanificacionService } from "../services/planificacion.service";

import * as moment from "moment";

import { DataPackage } from '../models/data-package';
import { OrdenTallerFechaService } from '../services/orden-taller-fecha.service';
import { OrdenTallerFecha } from '../models/ordenTallerFecha';

import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexPlotOptions,
  ApexXAxis,
  ApexDataLabels,
  ApexLegend
} from "ng-apexcharts";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  legend: ApexLegend;
  xaxis: ApexXAxis;
  plotOptions: ApexPlotOptions;
};

@Component({
  selector: "app-timeline-orden-taller-fecha",
  templateUrl: "./timeline-orden-taller-fecha.component.html",
  styleUrls: ["./timeline-orden-taller-fecha.component.css"]
})
export class TimelineOrdenTallerFechaComponent {
  @ViewChild("chart", { static: false }) chart: ChartComponent;

  ordenesTallerFecha: OrdenTallerFecha[];
  pedidoId: any;

  //RED => "#EE3222"
  //BLUE => "#1964B4"
  //GREEN => "#0AAA55"
  colorBar = "#1964B4";

  public chartOptions: Partial<ChartOptions>;

  constructor(private planificacionService: PlanificacionService,
    private ordenTallerFechaService: OrdenTallerFechaService,
    private route: ActivatedRoute,
    private location: Location) {
    this.chartOptions = {
      series: [
      ],
      chart: {
        height: 350,
        type: "rangeBar"
      },
      plotOptions: {
        bar: {
          horizontal: true
        }
      },
      dataLabels: {
        enabled: true,
        formatter: function (val) {
          var a = moment(val[0]);
          var b = moment(val[1]);
          var diff = b.diff(a, "days");
          return diff + (diff > 1 ? " days" : " day");
        }
      },
      xaxis: {
        type: "datetime"
      },
      legend: {
        position: "top"
      }
    };
  }

  ngOnInit() {
    //this.getPlanificacionesByPedido();
    this.getOrdenesTallerFechaByPedido();
  }

  getOrdenesTallerFechaByPedido(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.pedidoId = id;
    this.ordenTallerFechaService.getByPedido(id).subscribe((dataPackage) => {
      this.ordenesTallerFecha = <OrdenTallerFecha[]>(<DataPackage>dataPackage).data;
      this.chartOptions.series = this.getPlanificacionesSeries();
      //this.chartOptions.series = this.getPlanificacionesSeriesAdvanced();
    });
  }

  getPlanificacionesSeries() {
    let resultSeries = [{ data: [] }];
    for (let i = 0; i < this.ordenesTallerFecha.length - 1; i++) {
      let ordenesTallerFecha = this.ordenesTallerFecha[i];
      let ordenFechaInicio = new Date(ordenesTallerFecha.fechaInicio).getTime();
      let ordenFechaFin = new Date(ordenesTallerFecha.fechaFin).getTime();
      // let planificacionFin = new Date(this.planificaciones[i + 1].inicio).getTime();
      resultSeries[0].data.push({
        x: ordenesTallerFecha.taller.codigo,
        y: [
          ordenFechaInicio,
          ordenFechaFin
        ],
        fillColor: this.colorBar
      })
    }

    return resultSeries;
  }

  /*  getPlanificacionesSeries() {
    //let resultSeries = [{name: "",data:[]}];
    let resultSeries = [{name: "", data: [] }]
    for(let orden=0; orden < this.ordenesTallerFecha.length-1; orden++){
      let ordenTallerFecha = this.ordenesTallerFecha[orden];
      let ordenFechaInicio = new Date(ordenTallerFecha.fechaInicio).getTime();
      let ordenFechaFin = new Date(ordenTallerFecha.fechaFin).getTime();
      resultSeries[0].data.push({
        name: "Orden N° "+ordenTallerFecha.ordenId.toString(),
        data: [
          {
            x: ordenTallerFecha.taller.codigo,
            y: [
              ordenFechaInicio,
              ordenFechaFin
            ]
          }
        ]
      })

    return resultSeries;
    }
  } */

}