import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TalleresDetailComponent } from './talleres-detail.component';

describe('TalleresDetailComponent', () => {
  let component: TalleresDetailComponent;
  let fixture: ComponentFixture<TalleresDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TalleresDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TalleresDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
