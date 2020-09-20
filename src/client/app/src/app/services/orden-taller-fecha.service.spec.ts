import { TestBed } from '@angular/core/testing';

import { OrdenTallerFechaService } from './orden-taller-fecha.service';

describe('OrdenTallerFechaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrdenTallerFechaService = TestBed.get(OrdenTallerFechaService);
    expect(service).toBeTruthy();
  });
});
