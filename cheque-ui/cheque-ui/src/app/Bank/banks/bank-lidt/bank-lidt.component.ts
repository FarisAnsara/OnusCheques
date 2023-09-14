import {Component, OnInit} from '@angular/core';
import {BankServiceService} from "../bank-service.service";
import {Banks} from "../banks";

@Component({
  selector: 'app-bank-lidt',
  templateUrl: './bank-lidt.component.html',
  styleUrls: ['./bank-lidt.component.css']
})
export class BankLidtComponent implements OnInit{

    banks!: Banks[];

    constructor(private bankService: BankServiceService) {
    }

    ngOnInit():void {
      this.bankService.findAll().subscribe(data => {
          console.log(data);
        this.banks = data;
      })
    }


}
