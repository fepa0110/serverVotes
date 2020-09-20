import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoEquiposDetailComponent } from './tipo-equipos-detail.component';

describe('TipoEquiposDetailComponent', () => {
  let component: TipoEquiposDetailComponent;
  let fixture: ComponentFixture<TipoEquiposDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoEquiposDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoEquiposDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
