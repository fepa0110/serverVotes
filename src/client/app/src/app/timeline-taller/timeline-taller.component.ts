import { Component, Directive, Input, ViewChild } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Planificacion } from '../models/planificacion';
import { PlanificacionByFecha } from "../models/planificacionByFecha";

import { PlanificacionService } from "../services/planificacion.service";

import { TimelineChartsService } from "../services/timeline-charts.service";

import {
  NgbDateStruct,
  NgbCalendar,
  NgbDate,
} from "@ng-bootstrap/ng-bootstrap";

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
  selector: "app-timeline-taller",
  templateUrl: "./timeline-taller.component.html",
  styleUrls: ["./timeline-taller.component.css"]
})
export class TimelineTallerComponent {
  @ViewChild("chart", { static: false }) chart: ChartComponent;
  
  planificaciones: Planificacion[];
  byTallerFecha: PlanificacionByFecha;
  fechaDesdeDate: NgbDateStruct;
  fechaHastaDate: NgbDateStruct;

  cargando = 1;

  service: PlanificacionService;
  tallerId: any;

  //RED => "#EE3222"
  //BLUE => "#1964B4"
  colorBar = "#1964B4";

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
    private timeLineChartsService: TimelineChartsService,
    private calendar: NgbCalendar,
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

    this.fechaDesdeDate = this.calendar.getToday();
    this.fechaHastaDate = this.calendar.getToday();
  }

  ngOnInit() {
    this.getPlanificacionesByTaller();
    this.cargando = 0;
  }

  getPlanificacionesByTaller(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.byTallerFecha = {
      id: parseInt(id),
      fechaDesde: new Date,
      fechaHasta: new Date
    };
    this.tallerId = id;
    this.planificacionService.getByTaller(id).subscribe((dataPackage) => {
      this.planificaciones = <Planificacion[]>(<DataPackage>dataPackage).data;
      this.chartOptions.series = this.getPlanificacionesSeries();
      //this.chartOptions.series = this.getPlanificacionesSeriesAdvanced();
    });
  }

  getByTallerFecha(): void {
    const id = this.route.snapshot.paramMap.get('id');

    this.byTallerFecha.fechaDesde = new Date(
      this.fechaDesdeDate.year,
      this.fechaDesdeDate.month - 1,
      this.fechaDesdeDate.day
    );
    this.byTallerFecha.fechaHasta = new Date(
      this.fechaHastaDate.year,
      this.fechaHastaDate.month - 1,
      this.fechaHastaDate.day
    );

    this.byTallerFecha.id = parseInt(id);
    this.timeLineChartsService.findByTallerFecha(this.byTallerFecha)
      .subscribe(dataPackage => { 
        this.planificaciones = <Planificacion[]>(<DataPackage>dataPackage).data;
        this.chartOptions.series = this.getPlanificacionesSeries();
    });
  }

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
    let resultSeries = [{ name: "",data: [] }];
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
}