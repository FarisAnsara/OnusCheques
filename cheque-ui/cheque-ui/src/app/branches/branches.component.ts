import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-branches',
  templateUrl: './branches.component.html',
  styleUrls: ['./branches.component.css']
})
export class BranchesComponent {

  title: string = "Branches";

  constructor(private router: Router) {}

}
