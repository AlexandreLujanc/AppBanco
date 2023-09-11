import { TestBed } from '@angular/core/testing';

import { SesionServicesService } from './sesion-services.service';

describe('SesionServicesService', () => {
  let service: SesionServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SesionServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
