import { TestBed } from '@angular/core/testing';

import { TipoEquipoService } from './tipo-equipo.service';

describe('TipoEquipoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TipoEquipoService = TestBed.get(TipoEquipoService);
    expect(service).toBeTruthy();
  });
});
