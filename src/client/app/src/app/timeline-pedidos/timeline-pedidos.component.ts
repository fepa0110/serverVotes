import { Component, Directive, Input, ViewChild } from "@angular/core";
import { ActivatedRoute, Data } from '@angular/router';
import { Location } from '@angular/common';

import { Planificacion } from '../models/planificacion';

import { PlanificacionService } from "../services/planificacion.service";
import { PedidoService } from "../services/pedido.service";
import { DataPackage } from '../models/data-package';
import { OrdenTrabajoService } from '../services/orden-trabajo.service';
import { OrdenTrabajo } from '../models/ordenTrabajo';
import { PedidoFabricacion } from '../models/pedidoFabricacion';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import * as moment from "moment";
import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexPlotOptions,
  ApexXAxis,
  ApexFill,
  ApexDataLabels,
  ApexYAxis,
  ApexGrid,
  NgApexchartsModule
} from "ng-apexcharts";


export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  fill: ApexFill;
  dataLabels: ApexDataLabels;
  grid: ApexGrid;
  yaxis: ApexYAxis;
  xaxis: ApexXAxis;
  plotOptions: ApexPlotOptions;
};

@Component({
  selector: "app-timeline-pedidos",
  templateUrl: "./timeline-pedidos.component.html",
  styleUrls: ["./timeline-pedidos.component.css"]
})
export class TimelinePedidosComponent {
  @ViewChild("chart", { static: false }) chart: ChartComponent;

  planificaciones: Planificacion[];
  ordenesByPedido: OrdenTrabajo[];
  service: PlanificacionService;
  pedido: PedidoFabricacion;
  pedidoId: any;

  //RED => "#EE3222"
  //BLUE => "#1964B4"
  //GREEN => "#0AAA55"
  colorBar = "#1964B4";

  public chartOptions: Partial<ChartOptions>;

  constructor(private planificacionService: PlanificacionService,
              private pedidoService: PedidoService,
              private ordenTrabajoService: OrdenTrabajoService,
              private _modalService: NgbModal,
              private route: ActivatedRoute,
              private location: Location) {
    this.chartOptions = {
      series: [

      ],
      chart: {
        height: 400,
        type: "rangeBar"
      },
      plotOptions: {
        bar: {
          horizontal: true,
          distributed: true,
          barHeight: "80%",
          dataLabels: {
            hideOverflowingLabels: true
            // position: 'bottom'
          }
        }
      },
      dataLabels: {
        enabled: false,
        formatter: function (val, opts) {
          var label = opts.w.globals.labels[opts.dataPointIndex];
          var a = moment(val[0]);
          var b = moment(val[1]);
          var diff = b.diff(a, "days");
          return label + ": " + diff + (diff > 1 ? " days" : " day");
        },
        style: {
          colors: ["#f3f4f5", "#fff"]
        }
      },
      xaxis: {
        type: "datetime"
      },
      /*fill: {
        type: "gradient",
        gradient: {
          shade: "light",
          type: "vertical",
          shadeIntensity: 0.25,
          gradientToColors: undefined,
          inverseColors: true,
          opacityFrom: 1,
          opacityTo: 1,
          stops: [50, 0, 100, 100]
        }, */
      yaxis: {
        floating: true,
        show: true,
        showForNullSeries: false
      },
      grid: {
        borderColor: "#1964B4",
        row: {
          colors: ["#fff", "#fff"], //"#f3f4f5"
          opacity: 1
        }
      }
    };
  }

  ngOnInit() {
    this.getPedido();
    this.getPlanificacionesByPedido();
  }

  getPedido(): void{
    const id = this.route.snapshot.paramMap.get('id');
    this.pedidoService.get(id).subscribe((dataPackage) => {
      this.pedido = (<{ pedidoFabricacion: PedidoFabricacion }>(<DataPackage>dataPackage).data).pedidoFabricacion;
      this.pedido.fechaPedido = new Date(this.pedido.fechaPedido);
      this.pedido.fechaEntrega = new Date(this.pedido.fechaEntrega);
      // this.modalInfoPedido(this.pedido);
    });
  }

  getPlanificacionesByPedido(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.planificacionService.getByPedido(id).subscribe((dataPackage) => {
      this.planificaciones = <Planificacion[]>(<DataPackage>dataPackage).data;
      this.chartOptions.series = this.getPlanificacionesSeries();
      //this.chartOptions.series = this.getPlanificacionesSeriesAdvanced();
    });
  }

/*   getOrdenesByPedido(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.pedidoId = id;
    this.ordenTrabajoService.getByPedido(id).subscribe((dataPackage) => {
      this.ordenesByPedido = <OrdenTrabajo[]>(<DataPackage>dataPackage).data;
      this.chartOptions.series = this.getPlanificacionesByOrdenSeries();
      //this.chartOptions.series = this.getPlanificacionesSeries();
      //this.chartOptions.series = this.getPlanificacionesSeriesAdvanced();
    });
  } */

  getPlanificacionesSeries() {
    let resultSeries = [{ data: [] }];
    for (let i = 0; i < this.planificaciones.length - 1; i++) {
      let planificacion = this.planificaciones[i];
      let planificacionInicio = new Date(planificacion.inicio).getTime();
      let planificacionFin = new Date(planificacion.fin).getTime();
      // let planificacionFin = new Date(this.planificaciones[i + 1].inicio).getTime();
      resultSeries[0].data.push({
        x: planificacion.equipo.codigo,
        y: [
          planificacionInicio,
          planificacionFin
        ],
        fillColor: this.colorBar
      })
    }

    return resultSeries;
  }

  getPlanificacionesSeriesAdvanced() {
    let resultSeries = [{ name: "", data: [] }];
    for (let i = 0; i < this.planificaciones.length - 1; i++) {
      let planificacion = this.planificaciones[i];
      let planificacionInicio = new Date(planificacion.inicio).getTime();
      let planificacionFin = new Date(planificacion.fin).getTime();
      // let planificacionFin = new Date(this.planificaciones[i + 1].inicio).getTime();
      resultSeries[0].name = planificacion.ordenTrabajo.numero.toString();
      resultSeries[0].data.push({
        x: planificacion.equipo.codigo,
        y: [
          planificacionInicio,
          planificacionFin
        ]
      })

    }

    return resultSeries;
  }

/*   getPlanificacionesByOrdenSeries() {
    let resultSeries = [{ name: "", data: [] }];
    for(let orden = 0; orden < this.ordenesByPedido.length - 1; orden++){
      resultSeries[orden].name = this.ordenesByPedido[orden].id.toString();
      for (let i = 0; i < this.ordenesByPedido[orden].planificaciones.length - 1; i++) {
        let planificacion = this.ordenesByPedido[orden].planificaciones[i];
          let planificacionInicio = new Date(planificacion.inicio).getTime();
          let planificacionFin = new Date(planificacion.fin).getTime();
          // let planificacionFin = new Date(this.planificaciones[i + 1].inicio).getTime();
          resultSeries[orden].data.push({
            x: planificacion.equipo.codigo,
            y: [
              planificacionInicio,
              planificacionFin
            ]
          });
      }
    }

    return resultSeries;
  } */
}