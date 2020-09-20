import { TestBed } from '@angular/core/testing';

import { TimelineChartsService } from './timeline-charts.service';

describe('TimelineChartsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TimelineChartsService = TestBed.get(TimelineChartsService);
    expect(service).toBeTruthy();
  });
});
