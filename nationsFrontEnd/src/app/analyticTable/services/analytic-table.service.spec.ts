import { TestBed } from '@angular/core/testing';

import { AnalyticTableService } from './analytic-table.service';

describe('AnalyticTableService', () => {
  let service: AnalyticTableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnalyticTableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
