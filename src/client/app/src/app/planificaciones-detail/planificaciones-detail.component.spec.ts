import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanificacionesDetailComponent } from './planificaciones-detail.component';

describe('PlanificacionesDetailComponent', () => {
  let component: PlanificacionesDetailComponent;
  let fixture: ComponentFixture<PlanificacionesDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanificacionesDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanificacionesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
