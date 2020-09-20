import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanificacionPedidoComponent } from './planificacion-pedido.component';

describe('PlanificacionPedidoComponent', () => {
  let component: PlanificacionPedidoComponent;
  let fixture: ComponentFixture<PlanificacionPedidoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanificacionPedidoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanificacionPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
