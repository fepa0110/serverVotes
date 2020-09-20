import { TestBed } from '@angular/core/testing';

import { TypeaheadSearchService } from './typeahead-search.service';

describe('TypeaheadSearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TypeaheadSearchService = TestBed.get(TypeaheadSearchService);
    expect(service).toBeTruthy();
  });
});
