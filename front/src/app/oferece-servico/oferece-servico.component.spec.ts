import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfereceServicoComponent } from './oferece-servico.component';

describe('OfereceServicoComponent', () => {
  let component: OfereceServicoComponent;
  let fixture: ComponentFixture<OfereceServicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OfereceServicoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OfereceServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
