import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormBranchesComponent } from './form-branches.component';

describe('FormBranchesComponent', () => {
  let component: FormBranchesComponent;
  let fixture: ComponentFixture<FormBranchesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormBranchesComponent]
    });
    fixture = TestBed.createComponent(FormBranchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
