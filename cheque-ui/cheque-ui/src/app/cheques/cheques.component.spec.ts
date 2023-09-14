import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequesComponent } from './cheques.component';

describe('ChequesComponent', () => {
  let component: ChequesComponent;
  let fixture: ComponentFixture<ChequesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChequesComponent]
    });
    fixture = TestBed.createComponent(ChequesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
