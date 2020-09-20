import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TimelineTallerComponent } from './timeline-taller.component';

describe('TimelineTallerComponent', () => {
  let component: TimelineTallerComponent;
  let fixture: ComponentFixture<TimelineTallerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimelineTallerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimelineTallerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
