import { TestBed } from '@angular/core/testing';

import { PlanificadorService } from './planificador.service';

describe('PlanificadorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlanificadorService = TestBed.get(PlanificadorService);
    expect(service).toBeTruthy();
  });
});
