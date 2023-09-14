import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankLidtComponent } from './bank-lidt.component';

describe('BankLidtComponent', () => {
  let component: BankLidtComponent;
  let fixture: ComponentFixture<BankLidtComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BankLidtComponent]
    });
    fixture = TestBed.createComponent(BankLidtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
