import { Component, Directive, Input, ViewChild } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Planificacion } from '../models/planificacion';

import { ResultsPage } from "../results-page";

import { PlanificacionService } from "../services/planificacion.service";

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
import { DataPackage } from '../models/data-package';

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
  selector: "app-timeline-charts",
  templateUrl: "./timeline-charts.component.html",
  styleUrls: ["./timeline-charts.component.css"]
})
export class TimelineChartsComponent {
  @ViewChild("chart", { static: false }) chart: ChartComponent;

  // @Input() planificaciones: Planificacion[];
  planificaciones: Planificacion[];
  service : PlanificacionService;

  seriesDefault = {
    data: [
      {
        x: "Analysis",
        y: [
          new Date("2019-02-27").getTime(),
          new Date("2019-03-04").getTime()
        ],
        fillColor: "#008FFB"
      },
      {
        x: "Design",
        y: [
          new Date("2019-03-04").getTime(),
          new Date("2019-03-08").getTime()
        ],
        fillColor: "#00E396"
      },
      {
        x: "Coding",
        y: [
          new Date("2019-03-07").getTime(),
          new Date("2019-03-10").getTime()
        ],
        fillColor: "#775DD0"
      },
      {
        x: "Testing",
        y: [
          new Date("2019-03-08").getTime(),
          new Date("2019-03-12").getTime()
        ],
        fillColor: "#FEB019"
      },
      {
        x: "Deployment",
        y: [
          new Date("2019-03-12").getTime(),
          new Date("2019-03-17").getTime()
        ],
        fillColor: "#FF4560"
      }
    ]
  };

  public chartOptions: Partial<ChartOptions>;

  constructor(private planificacionService: PlanificacionService, 
    private route: ActivatedRoute,
    private location: Location) {
    this.chartOptions = {
      series: [
          
      ],
      chart: {
        height: 500,
        type: "rangeBar"       
      },
      plotOptions: {
        bar: {
          horizontal: true,
          distributed: true,
          dataLabels: {
            hideOverflowingLabels: true
          }
        }
      },
      dataLabels: {
        enabled: true,
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
      yaxis: {
        show: false
      },
      grid: {
        row: {
          colors: ["#f3f4f5", "#fff"],
          opacity: 1
        }
      }
    };
  }

  ngOnInit(){
    this.getPlanificaciones();
  }


  getPlanificacionesByPedido(): void {
    const id = this.route.snapshot.paramMap.get('id');
/*     if (id === 'new') {
      this.tipoEquipo = <TipoEquipo>{};
    } else {
      this.tipoEquipoService.get(id)
        .subscribe(dataPackage => this.tipoEquipo = <TipoEquipo>dataPackage.data);
    } */
    /* this.tipoEquipoService.get(id)
      .subscribe(dataPackage => this.tipoEquipo = <TipoEquipo>dataPackage.data); */
  }

  getPlanificaciones(): void {
    this.planificacionService.allPlanificaciones().subscribe((dataPackage) => {
      this.planificaciones = <Planificacion[]>(<DataPackage>dataPackage).data;
      this.chartOptions.series = this.getPedidosSeries();
    });
  }

  getPedidosSeries() {
    let resultSeries = [{ data: [] }];
    for (let i=0; i<this.planificaciones.length-1;i++) {
      let planificacion = this.planificaciones[i];
      let planificacionInicio = new Date(planificacion.inicio).getTime();
      let planificacionFin = new Date(this.planificaciones[i+1].inicio).getTime();
      resultSeries[0].data.push({
        x: planificacion.equipo.codigo,
        y: [
          planificacionInicio,
          planificacionFin
        ],
        fillColor: "#0A90D0"
      })
    }

    return resultSeries;
  }

  getPedidosPorListaSeries(planificaciones: Planificacion[]) {
    let resultSeries = [{ data: [] }];
    for (let i = 0; i < planificaciones.length - 1; i++) {
      let planificacion = planificaciones[i];
      let planificacionInicio = new Date(planificacion.inicio).getTime();
      let planificacionFin = new Date(planificaciones[i + 1].inicio).getTime();
      resultSeries[0].data.push({
        x: planificacion.equipo.codigo,
        y: [
          planificacionInicio,
          planificacionFin
        ],
        fillColor: "#0ADDD0"
      })
    }

    return resultSeries;
  }
}