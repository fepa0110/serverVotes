import { Component, OnInit } from '@angular/core';
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { NgbdModalConfirm } from "../modal-component";

import { TallerService } from '../services/taller.service';
import { ResultsPage } from "../results-page";

@Component({
  selector: 'app-talleres',
  templateUrl: './talleres.component.html',
  styleUrls: ['./talleres.component.css']
})
export class TalleresComponent implements OnInit {

  resultsPage: ResultsPage = <ResultsPage>{};
  pages: number[];
  pagesSize: number;
  currentPage: number = 1;

  constructor(
    private tallerService: TallerService,
    private _modalService: NgbModal
  ) { }

  ngOnInit() {
    this.getTalleres();
  }

  getTalleres(): void {
    this.tallerService.byPage(this.currentPage, 10).subscribe((dataPackage) => {
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
        that.tallerService.remove(id).subscribe((dataPackage) => that.getTalleres());
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
    this.getTalleres();
  };
}