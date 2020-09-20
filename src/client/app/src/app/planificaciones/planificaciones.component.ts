import { Component, OnInit } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
// import { NgbdModalConfirm } from "../modal-component";

import { ResultsPage } from "../results-page";
import { PlanificacionService } from '../services/planificacion.service';
import { PedidosDetailComponent } from '../pedidos-detail/pedidos-detail.component';

@Component({
  selector: 'app-planificaciones',
  templateUrl: './planificaciones.component.html',
  styleUrls: ['./planificaciones.component.css']
})
export class PlanificacionesComponent implements OnInit {
  resultsPage: ResultsPage = <ResultsPage>{};
  pages: number[];
  pagesSize: number;
  currentPage: number = 1;

  constructor(
    private planificacionService: PlanificacionService,
    private _modalService: NgbModal
  ) { }

  ngOnInit() {
    this.getPlanificaciones();
  }

  getPlanificaciones(): void {
    this.planificacionService.byPage(this.currentPage, 10).subscribe((dataPackage) => {
      this.resultsPage = <ResultsPage>dataPackage.data;
      this.pages = Array.from(Array(this.resultsPage.last).keys());
      this.pagesSize = this.pages.length;
    });
  }

  showPage(pageId: number): void {
    if (!this.currentPage) {
      this.currentPage = 1;
    }
    let page = pageId;
    if (pageId == -2) { // First
      page = 1;
    }
    if (pageId == -1) { // Previous
      page = this.currentPage > 1 ? this.currentPage - 1 : this.currentPage;
    }
    if (pageId == -3) { // Next
      page = this.currentPage < this.resultsPage.last ? this.currentPage + 1 : this.currentPage;
    }
    if (pageId == -4) { // Last
      page = this.resultsPage.last;
    }
    if (pageId > 1 && this.pages.length >= pageId) { // Number
      page = this.pages[pageId - 1] + 1;
    }
    this.currentPage = page;
    this.getPlanificaciones();
  };
}