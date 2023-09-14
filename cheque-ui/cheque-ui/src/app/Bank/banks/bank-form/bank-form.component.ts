import {Component, OnInit} from '@angular/core';
import {Banks} from "../banks";
import {ActivatedRoute, Router} from "@angular/router";
import {BankServiceService} from "../bank-service.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-bank-form',
  templateUrl: './bank-form.component.html',
  styleUrls: ['./bank-form.component.css']
})
export class BankFormComponent implements OnInit {

  // bank: Branches;
  bankForm!: FormGroup;

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private bankService: BankServiceService)
  {}

  ngOnInit(): void {
    this.bankForm = new FormGroup({
      name: new FormControl(null, [Validators.required])
    });
    }


  onSubmit() {
    console.log(this.bankForm.controls["name"].value);
    this.bankService.save(this.bankForm.controls["name"].value).subscribe(result => this.goToBankList());
  }
  goToBankList() {
    this.router.navigate(["/bank-post-and-get"])
  }


}
