import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BankServiceService} from "../../Bank/banks/bank-service.service";
import {Router} from "@angular/router";
import {BranchServiceService} from "../branch-service.service";

@Component({
  selector: 'app-form-branches',
  templateUrl: './form-branches.component.html',
  styleUrls: ['./form-branches.component.css']
})
export class FormBranchesComponent implements OnInit {

  branchForm!: FormGroup;

  constructor(
      private router: Router,
      private branchService: BranchServiceService
  ) {}

  ngOnInit(): void {
    this.branchForm = new FormGroup( {
      branchName: new FormControl(null, [Validators.required]),
      bankId: new FormControl(null, [Validators.required])
    })
    //
    // onSubmit() {
    //   console.log((this.branchForm.controls["branchName"]).value);
    //   this.branchService.save([this.branchForm.controls["branchName"], ])
    // }
  }





}
