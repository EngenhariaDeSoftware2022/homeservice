import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedServiceComponent } from './detailed-service.component';

describe('DetailedServiceComponent', () => {
  let component: DetailedServiceComponent;
  let fixture: ComponentFixture<DetailedServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailedServiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailedServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
