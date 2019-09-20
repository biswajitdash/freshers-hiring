import { TestBed } from '@angular/core/testing';

import { FresherInfoService } from './fresher-info.service';

describe('FresherInfoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FresherInfoService = TestBed.get(FresherInfoService);
    expect(service).toBeTruthy();
  });
});
