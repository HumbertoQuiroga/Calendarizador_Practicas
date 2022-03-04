import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaestrosCrudComponent } from './maestros-crud.component';

describe('MaestrosCrudComponent', () => {
  let component: MaestrosCrudComponent;
  let fixture: ComponentFixture<MaestrosCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaestrosCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaestrosCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
