import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanificacionGraficaComponent } from './planificacion-grafica.component';

describe('PlanificacionGraficaComponent', () => {
  let component: PlanificacionGraficaComponent;
  let fixture: ComponentFixture<PlanificacionGraficaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanificacionGraficaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanificacionGraficaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
