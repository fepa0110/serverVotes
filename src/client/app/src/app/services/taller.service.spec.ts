import { TestBed } from '@angular/core/testing';

import { TallerService } from './taller.service';

describe('TallerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TallerService = TestBed.get(TallerService);
    expect(service).toBeTruthy();
  });
});
