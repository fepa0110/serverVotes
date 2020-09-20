import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplanificacionPedidoComponent } from './replanificacion-pedido.component';

describe('ReplanificacionPedidoComponent', () => {
  let component: ReplanificacionPedidoComponent;
  let fixture: ComponentFixture<ReplanificacionPedidoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReplanificacionPedidoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReplanificacionPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
