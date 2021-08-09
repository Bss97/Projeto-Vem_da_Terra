import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroCategoriaComponent } from './cadastro-categoria.component';

describe('CadastroCategoriaComponent', () => {
  let component: CadastroCategoriaComponent;
  let fixture: ComponentFixture<CadastroCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroCategoriaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
