import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelaServicoComponent } from './tela-servico.component';

describe('TelaServicoComponent', () => {
  let component: TelaServicoComponent;
  let fixture: ComponentFixture<TelaServicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelaServicoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TelaServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
