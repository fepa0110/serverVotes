import { TestBed } from '@angular/core/testing';

import { OrdenTrabajoService } from './orden-trabajo.service';

describe('OrdenTrabajoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrdenTrabajoService = TestBed.get(OrdenTrabajoService);
    expect(service).toBeTruthy();
  });
});
