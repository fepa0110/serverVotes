import { Component, OnInit } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { NgbdModalConfirm } from "../modal-component";

import { TipoEquipoService } from '../services/tipo-equipo.service';
import { ResultsPage } from "../results-page";

@Component({
  selector: 'app-tipo-equipos',
  templateUrl: './tipo-equipos.component.html',
  styleUrls: ['./tipo-equipos.component.css']
})
export class TipoEquiposComponent implements OnInit {

  resultsPage: ResultsPage = <ResultsPage>{};
  pages: number[];
  pagesSize: number;
  currentPage: number = 1;

  constructor(
    private tipoEquipoService: TipoEquipoService,
    private _modalService: NgbModal
  ) { }

  ngOnInit() {
    this.getTipoEquipos();
  }

  getTipoEquipos(): void {
    this.tipoEquipoService.byPage(this.currentPage, 10).subscribe((dataPackage) => {
      this.resultsPage = <ResultsPage>dataPackage.data;
      this.pages = Array.from(Array(this.resultsPage.last).keys());
      this.pagesSize = this.pages.length;
    });
  }

  remove(id: number): void {
      const modal = this._modalService.open(NgbdModalConfirm);
      const that = this;
      modal.result.then(
        function () {
          that.tipoEquipoService.remove(id).subscribe((dataPackage) => that.getTipoEquipos());
        },
        function () { }
      );
      modal.componentInstance.title = "Eliminar tipo de equipo";
      modal.componentInstance.message = "¿Esta seguro de eliminar el tipo de equipo?";
      modal.componentInstance.description =
        "Si elimina el tipo de equipo no lo podrá utilizar luego.";
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
    this.getTipoEquipos();
  };
}