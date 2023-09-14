import { Component } from '@angular/core';
import {Router, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-banks',
  templateUrl: './banks.component.html',
  styleUrls: ['./banks.component.css']
})
export class BanksComponent {
    title: string = "Banks";

    constructor(private router: Router) {}

    navigateToGetPage() {
        this.router.navigate(['/bank-post-and-get']); // Navigate to the "Get Branches" page
    }

    navigateToPostPage() {
        this.router.navigate(['addBank']); // Navigate to the "Add Branches" page
    }
}
