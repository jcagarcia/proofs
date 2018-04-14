import { TestBed, inject } from '@angular/core/testing';

import { OwnerService } from './owner.service';

describe('OwnerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OwnerService]
    });
  });

  it('should be created', inject([OwnerService], (service: OwnerService) => {
    expect(service).toBeTruthy();
  }));
});
