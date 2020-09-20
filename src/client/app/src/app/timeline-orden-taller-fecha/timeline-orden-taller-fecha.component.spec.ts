import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TimelineOrdenTallerFechaComponent } from './timeline-orden-taller-fecha.component';

describe('TimelineOrdenTallerFechaComponent', () => {
  let component: TimelineOrdenTallerFechaComponent;
  let fixture: ComponentFixture<TimelineOrdenTallerFechaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimelineOrdenTallerFechaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimelineOrdenTallerFechaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
