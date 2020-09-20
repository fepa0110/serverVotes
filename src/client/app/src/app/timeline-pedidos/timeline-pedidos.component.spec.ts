import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TimelinePedidosComponent } from './timeline-pedidos.component';

describe('TimelinePedidosComponent', () => {
  let component: TimelinePedidosComponent;
  let fixture: ComponentFixture<TimelinePedidosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimelinePedidosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimelinePedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
